## 				 K Means Clustering				##
## 				   By Alex Hayes				##
## 				University of Liverpool			##
##												##
##			See README.txt for how to use		##
##												##

import numpy
import random

# Creates the feature space. A union of every feature across the data. depending on the parameter 
def process():
    featspace = get_union("data.txt")
    feat_index = {}
    for (fid, fval) in enumerate(featspace):
        feat_index[fval] = fid
    return feat_index
    print feat_index
	
# Gives the union
def get_union(fname):
    feats = set()
    F = open(fname)
    for line in F:
        for w in line.strip().split()[1:]:
            feats.add(w)
    F.close()
    return feats

def getStuff(file, featspace):
    data = list()
	# Creates an array for every line in the training data initialised to zeroes
    # data[0] is the review vector [1] is the index of the centroid it belongs to [2] is the label for the review
    for i in range(0, file_len(file)):
        datatwo = list()
        datatwo.append(numpy.zeros(len(featspace), dtype=float))
        datatwo.append(0)
        datatwo.append("Label")
        data.append(datatwo)
    # Checks if a feature in the review occurs in the feature-space, if it does then the index of that feature is set to one. 
	# i corresponds with the line number, which also corresponds with the index in the data list of each review.
    F = open(file)
    i = 0
    print "Processing dataset..."
    for line in F:
        line = line.strip().split()
        data[i][2] = line[0]
        for w in line[1:]:
            loc = featspace.get(w)
            data[i][0][loc] = 1
        i += 1
	# At the end of this there should be a list of arrays, each array will contain mainly zeroes but the occasional one. The index of each one will correspond
    # with whether a particular feature occurs in the data.
    return data

# Initialise as man centroids as desired as random points in the dataset
def initialiseCentroids(data, clustersNum): 
    centroids = list()
    sample = list()
    sample = random.sample(data, clustersNum)
    for s in sample:
        centroids.append(s[0])
    return centroids

def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

# Sets the clusters of the dataset
def getCluster(centroids, data):
    distances = list()
    for i in range(0, len(centroids)):
        distances.append(0)

    for d in data:	
        i = 0
        for a in distances:
            a = 0
        for c in centroids:
            x = d[0]/numpy.linalg.norm(d[0])
            y = c/numpy.linalg.norm(c)
            dis = numpy.linalg.norm(x-y)
            distances[i] = dis
            i+=1
        d[1] = distances.index(min(distances))
    return data

# Updates the centroids to the average vector of the cluster
def UpdateCentroids(centroids, data):
    for i in range(0, len(centroids)):
        pos = (numpy.zeros(len(centroids[0]), dtype=float))
        c = 0
        for d in data:
            if (d[1] == i):
                pos += d[0]
                c+=1
        if (c!=0):
            pos = pos/c
            centroids[i] = pos
    return centroids

# Updates the centroids to the dataset closest to average vector of the cluster
def UpdateCentroidsNearestNeighbor(centroids, data):
    for i in range(0, len(centroids)):
        pos = (numpy.zeros(len(centroids[0]), dtype=float))
        c = 0
        for d in data:
            if (d[1] == i):
                pos += d[0]
                c+=1
        if (c!=0):
            pos = pos/c
            centroids[i] = pos
    for i in range(0, len(centroids)):
        index = 0
        min = 0.0
        x = 0.0
        min = numpy.linalg.norm(data[0][0])
        for j in range(0, len(data[0])):
            x = numpy.linalg.norm(data[j][0]-centroids[i])
            if (x < min and i == data[j][1]):
                index = j
        centroids[i] = data[index][0]
    return centroids
	
# The clustering algorithm, gets the new centroids, if they haven't changed then returns the data 
# if they have changed then it assigns new centroids to the data and repeats.
def kmeans(centroids, data):
    newCentroids = UpdateCentroids(centroids, data)
    #newCentroids = UpdateCentroidsNearestNeighbor(centroids, data)
    convergence = 1
    for i in range (0, len(centroids)):
        if (newCentroids[i]!=centroids[i]).any():
            convergence = 0
    if convergence == 1:
        return data
    else:
        centroids = newCentroids
        data = getCluster(centroids, data)
        return kmeans(centroids, data)

# Builds a label arrays
def buildLabels(data):
    labels = list()
    for d in data:
        item = list()
        item = [d[2],0]
        if item not in labels:
            labels.append(item)
    return labels

# Puts together the amount of each label in each cluster
def cluster(centroids, data):
    clusters = list()
    for i in range(0, len(centroids)):
        cluster = list()
        labels = buildLabels(data)
        for d in data:
            for l in labels:
                if (l[0]==d[2] and d[1]==i):
                    l[1] +=1
        cluster.append(labels)
        cluster.append("CLUSTER NAME")
        clusters.append(cluster)
    return clusters

# Assigns the datatype of the cluster to the label that appears the most in that cluster
def assignClusterType(clusters):
    for c in clusters:
        mindex = 0
        m = 0
        for i in range(len(c[0])):
            if (c[0][i][1]>m):
                m = c[0][i][1]
                mindex = i
        c[1] = c[0][mindex][0]
    return clusters

# Merges clusters with the same type
def mergeClusters(clusters, i):
#    print i
    length = len(clusters)
    # i is the index of the element being compared to
    # If at end of the list then return the clusters as there are no more merges to be made
    if (i+1 >= length):
        return clusters
    else:
        j = i+1
        while (j<length):
            # If the labels are the same then merge 
            if (clusters[i][1] == clusters[j][1]):
                for q in range(0, len(clusters[0][0])):
                    clusters[i][0][q][1] += clusters[j][0][q][1]
                del(clusters[j])
                length-=1
            else:
                j+=1
        # All clusters with a label the same as i should now be gone so the method is called again to merge
        # anything identical to the element that occurs after i
        return mergeClusters(clusters, i+1)

# Returns the average recall of the clustering
# Just for for convenience I've hardcoded 51 in as that's how many reviews there are of each kind
def getRecall(clusters):
    recalls = list()
    for c in clusters:
        s = 0.0
        for r in c[0]:
            if (r[0] == c[1]):
                s += r[1]
        recalls.append(s/51)
    t = 0.0
    for r in recalls:
        t += r
    recall = t/len(clusters)
    return recall
        
# Returns the average precision of the clusters
def getPrecision(clusters):
    precisions = list()
    for c in clusters:
        p = 0.0
        s = 0.0
        t = 0.0
        for r in c[0]:
            t += r[1]
            if (r[0] == c[1]):
                s += r[1]
        p = s/t
        precisions.append(p)
    t = 0.0
    for p in precisions:
        t += p
    precision = t/len(clusters)
    return precision
	
def getFscore(p, r):
    numerator = 2*p*r
    denominator = p + r
    return numerator/denominator

if __name__ == "__main__":
    featspace = process()
    data = getStuff("data.txt", featspace)
    for k in range(2, 20):
        iterations = 200
        pM = 0.0
        rM = 0.0
        fM = 0.0
        for i in range(0, iterations):
            #print "Iteration: {0}".format(iterations)
            #k = 20
            centroids = initialiseCentroids(data, k)
            data = getCluster(centroids, data)
            #print "Performing K-means clustering..."
            data = kmeans(centroids, data)
            clusters = cluster(centroids, data)
            clusters = assignClusterType(clusters)
            clusters = mergeClusters(clusters, 0)
            p = getPrecision(clusters)
            r = getRecall(clusters)
            f = getFscore(p, r)
            pM += p
            rM += r
            fM += f
            '''
            print "Merged clusters"
            print " "
            for c in clusters:
                print "Cluster Data: {0}".format(c[0])
                print "Cluster Type: {0}".format(c[1])
                print " "
            print "number of clusters is {0}".format(len(clusters))
            print "Precision"   
            print p
            print "Recall"
            print r
            print "F score"
            print f
            '''
        print "_______________________________"
        print " "
        print "k value {0}, iterations {1}".format(k, iterations)			
        print " "
        print "Macro Averaged Precision over"
        print pM/iterations
        print " "
        print "Macro Averaged Recall over"
        print rM/iterations
        print " "
        print "Macro Averaged F Score over"
        print fM/iterations
        print "_______________________________"

# Debug methods below
# Print number of features in dataset
#    s = 0
#    for i in range(0, len(data[0][0])):
#        s += data[0][0][i]
#    print s
# Detect duplicate data		    
#    for i in range(0, len(data)):
#        for j in range(i+1, len(data)):
#            if (data[i][0]==data[j][0]).all():
#                print "Duplicate data"
# Print number of features in centroids
#    for c in centroids:
#        s = 0
#        for p in c:
#            s += p
#        print s
# Detect duplicate centroids
#    for i in range(0, len(centroids)):
#        for j in range(i+1, len(centroids)):
#            if (centroids[i]==centroids[j]).all():
#                print "Duplicate data"

    