# 가장 긴 증가하는 부분 수열 2 - 12015 

[문제 링크](https://www.acmicpc.net/problem/12015) 

### 성능 요약

메모리: 121232 KB, 시간: 640 ms

### 분류

이분 탐색, 가장 긴 증가하는 부분 수열: O(n log n)

### 제출 일자

2025년 1월 25일 01:30:48

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>

### 느낀점

- 그저께 풀었던 줄세우기 문제에서 처음 lis 알고리즘을 알게 되어서, 이 문제도 그렇게 풀면 되는 줄 알았는데 바로 시간초과였다.
- 숫자 크기랑 티어가 의심스럽긴 했다(사실 티어 보고 풀면 안되는데ㅠ)
- LIS의 또 다른 풀이를 알게 되어 좋았다.

### 설계 : 30분 - 참고함

- 기존의 LIS 기본 풀이는 숫자를 1~n인덱스까지 i로 순회하면서 그 앞의 숫자들을 모두 순회해 가장 긴 증가하는 부분수열에 길이를 연장해가는 방법이었다. O(N^2)
- 이번 방법에서는 저장되는 수열의 모습이 실제 구해진 수열의 모습과는 상관이 없다. 그저 가장 긴 증가하는 부분 수열의 길이만 궁금할 뿐이다.
- 그러려면 수열을 이루는 각 위치가 가능한 가장 작은수로 이루어져야 그 뒤에 올 수에 대해 모든 경우의 수를 고려할 수 있다.
- 따라서 판단하려는 수가 현재 LIS의 마지막 수보다 크면 LIS길이를 늘려 수를 추가하고, 그렇지 않다면 적당한 위치에 해당 위치 최소값으로 갱신해줘야 한다.
    - ex) {1, 3, 2, 5, 4, 6}
    - 1 → {1}
    - 3 → {1, 3}
    - 2 → {1, 2}
    - 5 → {1, 2, 5}
    - 4 → {1, 2, 4}
    - 6 → {1, 2, 4, 6}
- 이 적당한 위치를 찾는 방법을 이분탐색으로 해서 O(N logn)의 시간복잡도를 갖는다.