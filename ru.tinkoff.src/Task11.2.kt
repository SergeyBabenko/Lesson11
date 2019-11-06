fun main() {
    val n = readLine()?.toInt()
    val tree = readLine()?.split(" ")
    if (tree != null && tree.size == n) {
        val heights = mutableListOf<Int>()
        val nodeHeights = mutableMapOf<Int, Int>()
        for (i in tree.indices) {
            nodeHeights[i] = getHeight(tree[i].toInt(), tree, nodeHeights)
        }
        println(nodeHeights.values.max())
    }
}

fun getHeight(node: Int, tree: List<String>, nodeHeights: Map<Int, Int>): Int {
    var localHeight = 1
    var i = node
    while (i >= 0) {
        if (i in nodeHeights.keys) {
            localHeight += nodeHeights.getValue(i)
            break
        } else {
            i = tree[i].toInt()
            localHeight++
        }
    }
    return localHeight
}

