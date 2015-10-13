"""
k-nn classifier
"""

import numpy

def getFeatures(fname)
    a = set()
    with open(fname) as feat_file:
        for line feat_file:
            fv = line.strip().split()
            for w in fv:
                a.add(w)
    return a

def process():
    feat_space = get_feature_space("train.positive")
    feat_space.union(get_feature_space("train.negative"))	
    feat_space.union(get_feature_space("test.positive"))	
    feat_space.union(get_feature_space("test.negative"))
    print "Dimensionality of the feature is space =", len(feat_space)
	pass
	
if __name__ == "__main__":
    process()