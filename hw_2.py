# Реализация пирамидальной сортировки на Python

# Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является индексом в arr[]. n - размер кучи
def heapify(arr, n, i):
    largest = i  # Инициализировать наибольший как root
    left = 2 * i + 1
    right = 2 * i + 2

    # Проверяем существует ли левый дочерний элемент больший, чем корень

    if left < n and arr[i] < arr[left]:
        largest = left

    # Проверяем существует ли правый дочерний элемент больший, чем корень

    if right < n and arr[largest] < arr[right]:
        largest = right

    # Заменяем корень, если нужно
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  # свап

        # Применяем heapify к корню.
        heapify(arr, n, largest)


# Основная функция для сортировки массива заданного размера
def heapSort(arr):
    n = len(arr)

    # Построение max-heap.
    for i in range(n, -1, -1):
        heapify(arr, n, i)

    # Один за другим извлекаем элементы
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]  # свап
        heapify(arr, i, 0)


# Test
arr = [45, 23, 11, 5, 6, 7, 34, 78, 0, 1]
heapSort(arr)
len_n = len(arr)
print("Отсортированный массив")
print([arr[i] for i in range(len_n)])
