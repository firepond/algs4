class binomialCount:

    def __init__(self, N, k):
        self.binomialCount = [[-1 for col in range(k + 1)] for row in range(N + 1)]
        print("Init")

    def count(self, N, k):
        # print("N:", N, ", k:", k)
        if ( N == 0 and k == 0 ) :
            return 1

        if ( N == 0 ) :
            return 3
        
        if ( k == 0 ):
            return 2 * N + 1

        if ( self.binomialCount[N][k] == -1 ) :
            self.binomialCount[N][k] = self.count(N - 1, k - 1) + self.count(N - 1, k) + 1
        return self.binomialCount[N][k]

print("Start")
N = 100
k = 50
x = binomialCount(N, k)
a = x.count(N, k)
print("N:", N, ", k:", k, ", counts:", a)