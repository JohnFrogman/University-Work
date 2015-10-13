//							  K-Means Clustering							//
// 				   				By Alex Hayes								//
// 							University of Liverpool							//
//																			//

Put the K-Means clustering script in the same folder as data.txt, navigate to
the folder and type python kmeans.py to execute the script. It will cluster
the dataset and print out the macro averaged recall, precision and f-score to
the command line.

By default the script will use the average vector of a cluster to calculate
the centroids, if you want to change this navigate to line 247 in kmeans.py
and change the type from 0 to any non-zero value. 

By default the script runs over 200 iterations to calculate the macro averages
this can be changed at line 251, 200 iterations provides a smooth curve with 
regards to precision, recall and f-score but it takes time and is probably
a bit overkill.

Calculating the recall with an alternative dataset will give problems as the 
number of reviews of each type is exactly 51 in the provided dataset, and I
just put 51 straight into the python script rather than having the script 
count the quantity of different reviews each time.