package com.cy.test;

public class Test1 {
//1、有表score_table(id, score)，其中id,score均为正整数且不相同
//            输出该表中socre第二大的id
//   select id from ( select id from score_table s order by score desc limit 2) tmp order by tmp.id desc limit 1
//    突然忘了，先这样实现
//    select id from score_table s order by score desc limit 1,1

//2、有2张表，表1为任务表，记录每个人每天完成任务数，task_table(id, user_id, log_date, task_comp_num) 其中，
// 各条数据用户id，记录日期可能重复，即某个用户每天可能分多次完成任务
//    格式如 id_1, user_id_1, 2024-01-01, 3;
//    id_2, user_id_1, 2024-01-01, 4;
//    id_3, user_id_2, 2024-01-01, 4;
//    id_4, user_id_2, 2024-01-02, 4;
//    表2为用户信息表，user_table(id, user_id, user_name) 记录了用户id对应姓名。
//    写sql语句，统计 2024年1-3月每个人完成任务总数。只输出姓名，完成任务总数，每人仅一条数据。
//    select name,sum(t.task_comp_num) from task_table t left join user_table u  on t.user_id=u.user_id
//    where t.log_date>='2024-01-01' and t.log_date<'2024-04-01'
//    group by t.user_id

//            3、新建工程，实现接口满足以下条件：
//    通过GET请求localhost:8083/getValue?key=XXX时，接口返回应用配置项中提前配置的各个key对应的值。
//    输入配置以外的key抛异常，配置项中有 key为A、B、C，对应的值为1、2、3。
//    接口增加校验，限制key只能传配置项中内容。

//            4、实现一个函数，接受入参String filePath，返回该目录整个目录下所有的图片格式的文件名称
//    List<String> getPicName(String filePath)



}
