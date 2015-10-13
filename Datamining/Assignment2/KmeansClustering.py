def get_coocs(fname):
    T = {}
    with open(fname) as F:
        for line in F:
            feats = line.strip().sokut()[1:]
            for i in range(0, len(feats)):
                for j in range()
                if feats[i] != feats[j]:
                    pair = (feats[i], feats[j])
                    if pair in T: