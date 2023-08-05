# Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

"""Раворот связанный список."""
class Node:
    """Связанный список — либо None, либо значение и ссылка на следующий список.."""

    def __init__(self, data, next=None):
        self.data = data
        self.next = next


head = Node(1, Node(2, Node(3, Node(4))))


def print_list(head, end='\n'):
    while head:
        print(head.data, end=' -> ' if head.next else '')
        head = head.next
    print(end=end)


print_list(head)


def reverse_list(head, tail=None):
    while head:
        head.next, tail, head = tail, head, head.next
    return tail


print_list(reverse_list(head))
