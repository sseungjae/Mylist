package org.techtown.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            //리스트를 만든다.
            val names = listOf("홍길동1", "홍길동2", "홍길동3")
            //names2의 리스트의 원소개수는 3 홍길동 0 +1 홍길동 1+1 홍길동 2+1
            val names2 = List<String>(3, { index -> "홍길동${index + 1}" })
            //변경 가능한 리스트를 만든다. 변경 불가능한 리스트는 Immutable List
            val names3 = mutableListOf<String>("홍길동1", "홍길동2", "홍길동3")
            //비어있는 리스트 만드기 null값도 없다.
            val names4 = emptyList<String>()
            //변경 가능한 리스트 중 하
            val names5 = arrayListOf<String>("홍길동1", "홍길동2", "홍길동3")

            textView.append("\n${names.joinToString()}")
            textView.append("\n${names2.joinToString()}")
            textView.append("\n${names3.joinToString()}")
            textView.append("\n${names4.joinToString()}")
            textView.append("\n${names5.joinToString()}")
        }

         button2.setOnClickListener {
             //변수 digits의 리스트를 만든다. int형으로 (1, 2, 3)
             val digits = arrayListOf<Int>(1, 2, 3)
             //digits안에 세트한다. 2번 인텍스에 4를 -> 1, 2, 4
             digits.set(2, 4)
             //digits의 2번 인덱스를 얻는다. 4
             val aDigits = digits.get(2)
             //aDigits는 4
             textView.append("\n세 번째 숫자 : ${aDigits}")
             //리스트의 원소 갯수는 3 -> 1,2, 4
             textView.append("\n원소 개수 : ${digits.count()}")

             //digits에 5를 추가한다. -> 1, 2, 4, 5
             digits.add(5)
             //만약 digits의 내용물에 5가 있다면
             if(digits.contains(5)) {
                 //aIndex는 digits의 5번의 인덱스 -> 3
                 val aIndex = digits.indexOf(5)
                 //digits3은 digits에서 자른다. 인데스 1~3번을
                 // 1, 2, 4, 5 -> 2, 4, 5
                 val digits3 = digits.slice(1..aIndex)
                 //digits3을 출력한다.
                 textView.append("\n${digits3.joinToString()}")
             }
         }

        button3.setOnClickListener {
            //변수 digits는 리스트를 갖는다. Int로 2, 1, 3
            val digits = arrayListOf<Int>(2, 1, 3)
            //digits에서 하나씩 꺼낸다.
            digits.forEach{elem -> textView.append("$elem")}

            textView.append("\n")
            //elem을 반복한다.
            for (elem in digits) {
                textView.append("$elem")
            }

            textView.append("\n")
            //iterator메소를 사용한다. while과 항상 같이쓴다.
            // hasNext나 next도 세트라고 생각해도 된다.
            val iter = digits.iterator()
            while (iter.hasNext()){
                val elem = iter.next()
                textView.append("$elem")
            }
        }

        button4.setOnClickListener {
            //Int로 된 리스트ㅡ 만든다.
            val digits = arrayListOf<Int>(2, 1 , 3)

            //변수 sorted는 digits를 오름차순한 것 1, 2, 3
            val sorted = digits.sorted()
            //1, 2, 3
            textView.append("\n${sorted.joinToString()}")

            //sortedDesc는 didits를 내림차순 한 것 3, 2, 1
            val sortedDesc = digits.sortedDescending()
            //3, 2, 1
            textView.append("\n${sortedDesc.joinToString()}")

            textView.append("\n")
            //digit에 필터를 사용 -> elem변수 elem이 1보다 크 때 elem을 하나씩 꺼내본다.
            //즉 digits의 안의 요소 중에 1보다 큰 요소만 출력 2, 3
            digits.filter { elem -> elem > 1 }.forEach { elem ->textView.append("$elem") }
        }
    }
}