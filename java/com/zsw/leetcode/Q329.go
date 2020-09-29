package leetcode

var dx = []int{-1, 0, 1, 0}
var dy = []int{0, 1, 0, -1}
var m int
var n int

func longestIncreasingPath(matrix [][]int) int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}
	m = len(matrix)
	n = len(matrix[0])

	flag := make([][]int, m)
	for i := 0; i < m; i++ {
		flag[i] = make([]int, n)
	}
	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			res = max(res, dfs(i, j, matrix, flag))
		}
	}
	return res
}

func dfs(i int, j int, matrix [][]int, flag [][]int) int {
	if flag[i][j] != 0 {
		return flag[i][j]
	}
	flag[i][j]++
	for k := 0; k < 4; k++ {
		newI := i + dx[k]
		newJ := j + dy[k]
		if newI >= 0 && newJ >= 0 && newI < m && newJ < n && matrix[newI][newJ] > matrix[i][j] {
			flag[i][j] = max(flag[i][j], dfs(newI, newJ, matrix, flag)+1)
		}
	}
	return flag[i][j]
}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
