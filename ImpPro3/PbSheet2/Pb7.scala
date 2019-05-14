/*

Issues: n*n may overflow
        It is slow for big tests
        It should take only positive int values

Possible solution:  We want to check sqrt(n)*sqrt(n) == n (solves the overflow problem and it may be faster)
                    Because sqrt(n) is irrational, it will always be an approximation of the actual result.
                    so we check if n.toFloat - sqrt(n)*sqrt(n) < e, where e is a fixed sufficiently small value

*/
