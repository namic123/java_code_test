// 프로그래머스 1레벨 - 바탕화면 정리
// 문제 설명
// 코딩테스트를 준비하는 머쓱이는 프로그래머스에서 문제를 풀고 나중에 다시 코드를 보면서
// 공부하려고 작성한 코드를 컴퓨터 바탕화면에 아무 위치에나 저장해 둡니다. 저장한 코드가
// 많아지면서 머쓱이는 본인의 컴퓨터 바탕화면이 너무 지저분하다고 생각했습니다. 프로그래머스에서
// 작성했던 코드는 그 문제에 가서 다시 볼 수 있기 때문에 저장해 둔 파일들을 전부 삭제하기로 했습니다.
//컴퓨터 바탕화면은 각 칸이 정사각형인 격자판입니다. 이때 컴퓨터 바탕화면의 상태를 나타낸 문자열 배열
// wallpaper가 주어집니다. 파일들은 바탕화면의 격자칸에 위치하고 바탕화면의 격자점들은 바탕화면의
// 가장 왼쪽 위를 (0, 0)으로 시작해 (세로 좌표, 가로 좌표)로 표현합니다. 빈칸은 ".", 파일이 있는 칸은
// "#"의 값을 가집니다. 드래그를 하면 파일들을 선택할 수 있고, 선택된 파일들을 삭제할 수 있습니다.
// 머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며
// 드래그로 파일들을 선택하는 방법은 다음과 같습니다.
//드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로
// 이동한 뒤 마우스 왼쪽 버튼을 떼는 행동입니다. 이때, "점 S에서 점 E로 드래그한다"고 표현하고 점
// S와 점 E를 각각 드래그의 시작점, 끝점이라고 표현합니다.
//점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.
//점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이 선택됩니다.

package codetest.lv1;
import java.util.ArrayList;

public class CodeTest11 {
    private int[] CoordinateCalculator(ArrayList<Integer> x, ArrayList<Integer> y){                     // 좌표 값을 구해주는 메서드
        int min_x=51, max_x=0;
        int min_y=51, max_y=0;
        for (int i = 0; i <x.size(); i++) {                                                             // x와 y의 최소 최대 값을 구해주는 메서드
            min_x = Math.min(x.get(i),min_x);
            max_x = Math.max(x.get(i),max_x);

            min_y= Math.min(y.get(i),min_y);
            max_y= Math.max(y.get(i),max_y);
        }
        int[] return_coordinate ={min_y,min_x,max_y+1,max_x+1};
        return return_coordinate;                                                                      // 좌표 값 리턴
    }
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        ArrayList<Integer> xCoordinate = new ArrayList<Integer>();                                      // 모든 요소의 x값
        ArrayList<Integer> yCoordinate = new ArrayList<Integer>();                                      // 모든 요소의 y값
        for(int i=0; i<wallpaper.length;i++){
            for (int j=0; j<wallpaper[i].length();j++) {
                if(wallpaper[i].charAt(j) == '#'){
                    xCoordinate.add(j);
                    yCoordinate.add(i);
                }
            }
        }
        answer = CoordinateCalculator(xCoordinate,yCoordinate);
        return answer;                                                                                  // 좌표 값 리턴
    }
}
