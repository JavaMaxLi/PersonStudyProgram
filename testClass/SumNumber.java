package com.tasoft.syb.test;

import java.util.ArrayList;
import java.util.List;
/*2个链表相加只能保持个位，需考虑进位，不足补0 逆序反回结果*/
public class SumNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//l1[2,4,3]  l2[5,6,4] 243+564 = 807 逆序=708
        //val=0 next=null
        //ListNode result = new ListNode(0);
        ListNode current = new ListNode(0);
            ListNode result = current;
        int carry = 0;
        //先判断l1和l2是否为空
        while(l1 != null || l2 != null) {
            //如果为空 补0
            /*1. l1.val = 2; l2.val = 5 ; sum=2+5=7; carry=7/10=0; value=7%10=7 current=[0,7]
              2. l1.val = 4; l2.val = 6 ; sum=4+6=10;carry=10/10=1;value=10%10=0
            * */
            int num1 = l1 == null ? 0:l1.val;
            int num2 = l2 == null ? 0:l2.val;
            int sum = num1 +num2 + carry;
            carry = sum/10;
            sum = sum%10;
            //987 + 023
                current.next = new ListNode(sum);
                current = current.next;


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);

        }

        return  result;
    }
}
