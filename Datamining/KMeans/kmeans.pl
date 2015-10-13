## 				 K Means Clustering				##
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
        for w in line.strip().split():
            feats.add(w)
    F.close()
    return feats	