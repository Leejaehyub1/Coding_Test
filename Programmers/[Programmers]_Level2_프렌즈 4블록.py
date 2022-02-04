def solution(m, n, board):
    board = [list(b) for b in board]
    board_trans = []
    for x in range(len(board[0])):
        temp = []
        for y in range(len(board)):
            temp.insert(0, board[y][x])
        board_trans.insert(0, temp)

    result = -1
    sum = 0

    while (result != 0):
        delete_list = []
        for i in range(1, len(board_trans)):
            for k in range(1, len(board_trans[0])):
                if (board_trans[i][k] != '_' and board_trans[i - 1][k - 1] == board_trans[i - 1][k] and board_trans[i][
                    k - 1] == board_trans[i][k] and board_trans[i - 1][k] == board_trans[i][k - 1]):
                    delete_list.append((i - 1, k - 1))
                    delete_list.append((i - 1, k))
                    delete_list.append((i, k - 1))
                    delete_list.append((i, k))

        delete_list = set(delete_list)
        result = len(delete_list)
        sum += len(delete_list)

        board_after = []
        for i in delete_list:
            board_trans[i[0]][i[1]] = '0'

        for t in board_trans:
            while '0' in t:
                t.remove('0')
                t.append('_')
            board_after.append(t)
        board_trans = board_after

    return sum