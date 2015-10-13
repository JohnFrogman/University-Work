## 				   	Perceptron					##
## 				   By Alex Hayes				##
## 				University of Liverpool			##
##												##
##			See README.txt for how to use		##
##												##

import time
import numpy
from random import shuffle

# Creates the feature space. A union of every feature across the data. depending on the parameter 
def process():
    featspace = get_union("train.positive")
    featspace = featspace.union(get_union("train.negative"))
    featspace = featspace.union(get_union("test.positive"))
    featspace = featspace.union(get_union("test.negative"))
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
        for w in line.strip().split():
            feats.add(w)
    F.close()
    return feats	

# This method gets the data from the file "file".
def getStuff(file, featspace):
    data = list()
    # Creates an array for every line in the training data initialised to zeroes
    for i in range(0, file_len(file)):
        data.append(numpy.zeros(length, dtype=float))
    # Checks if a feature in the review occurs in the feature-space, if it does then the index of that feature is set to one. 
	# i corresponds with the line number, which also corresponds with the index in the data list of each review.
    F = open(file)
    i = 0
    print "Processing dataset..."
    for line in F:
        for w in line.strip().split():
            data[i][featspace.get(w)] = 1
	i += 1
    # At the end of this there should be a list of arrays, each array will contain mainly zeroes but the occasional one. The index of each one will correspond
    # with whether a particular feature occurs in the data.
    return data
	
# Returns the length of a file, this is probably highly unnecessary but I was learning python as I went so it was included.
def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1
	
# The train algorithm, this trains the weight vector on the dataset "data" for as many iterations as the user wants.
def train(data, y, weights):
    misclassifications = float(0)
    global b
    if y < 0:
        classification = "Negative"
    else:
        classification = "Positive"
    shuffle(data)
    for d in data:
        a = numpy.dot(d, weights) + b
        if y*a <= 0:
            weights += d*y
            b += y
            misclassifications += 1
    dataLength = float(len(data))
    print "{0} Train accuracy: {1}%".format(classification, round(100-100*(misclassifications/dataLength), 2))
    return weights

# fname is the filename of the test data, weights is the vector of weights obtained after training and y is whether the test data is positive or negative
# This method prints the percentage of correct classifications and also returns its value
def testFile(data, weights, y, fname):
    correctness = 0
    length = len(data)
    print "Testing dataset..."
    for d in data:
        a = numpy.dot(weights, d) + b
        if numpy.sign(a) == numpy.sign(y): 
            correctness += 1
    percent = float(correctness)/float(length)
    percent = percent*100
    print "The dataset {0} was classified correctly {1}% of the time.".format(fname, round(percent, 2))	
    return percent
	
# Main method, first the feature-space is processed from the test and train data, afterwards the weights and bias term are initialised at zero.
# The datasets are read in and then the weight vector is trained, testing occurs after each iteration and accuracy is printed as well.
if __name__ == "__main__": 
    iterations = 60
    start = time.time()    
    featspace = process()
    length = len(featspace)
    weights = numpy.zeros(length)
    b = 0
    neg = getStuff("train.negative", featspace)
    negTest = getStuff("test.negative", featspace)
    pos = getStuff("train.positive", featspace)
    posTest = getStuff("test.positive", featspace)
	
    print "Training..."
    # The training algorithm, the weights are trained on the negative data followed by the positive data, the accuracy of the training and the
    # testing is then printed before moving onto the next iteration. A more effective way to do this would probably be to merge the positive and negative
    # datasets and associate the classification of the data with another dimension on the data array. If the training is only on negative instances then
    # the later data points are less effective. Exposing the training to a mixture of positive and negative data would reduce the effect of diminishing returns
    # that you get with using a full dataset of just one classification. However at this point in time I dont have the time to make this change.
    for i in range (0, iterations):	
        print "Training: Iteration {0}".format(i)
        weights = train(pos, 1, weights)
        weights = train(neg, -1, weights)
        p1 = testFile(posTest, weights, 1, "test.positive")
        p2 = testFile(negTest, weights, -1, "test.negative")
        print "Overall Accuracy: {0}%".format(round(p1/2 + p2/2, 2))
        i += 1
    print b
    p1 = testFile(posTest, weights, 1, "test.positive")
    p2 = testFile(negTest, weights, -1, "test.negative")
    print "Overall Accuracy: {0}%".format(round(p1/2 + p2/2, 2))
    end = time.time()
	
    print "Time elapsed: {0}s".format(round(end - start, 2))