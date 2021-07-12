def solution(lines):
    answer = 0
    time_list = []
    for line in lines:
        line = line.split(" ")
        temp_time = line[1].split(":")
        interval = line[2]
        end_time = int(temp_time[0]) * 3600000 + int(temp_time[1]) * 60000 + int(temp_time[2].replace('.', ''))

        start_time = end_time - int(float(interval[:-1]) * 1000) + 1
        if start_time < 0:
            start_time = 0

        time_list.append([start_time, end_time])

    if (len(time_list) == 1):    return 1

    for i in range(len(time_list)):
        count = 1
        end_time = time_list[i][1]
        for k in range(len(time_list)):
            if i == k:  continue

            if time_list[k][0] <= end_time and end_time + 1000 <= time_list[k][1]:
                count += 1

            elif end_time <= time_list[k][0] < end_time + 1000:
                count += 1

            elif end_time <= time_list[k][1] < end_time + 1000:
                count += 1

        if answer < count:
            answer = count

    return answer