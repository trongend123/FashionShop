/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.MyDao;
import Model.Comment;
import Model.Product;
import Util.SqlQuery;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CommentDao extends MyDao implements SqlQuery {

    public void addComment(Comment comment) {
        try {
            ps = con.prepareStatement(SqlQuery.comment.addComment);
            ps.setInt(1, comment.getProductId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getContent());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Comment> getListCommentByProductId(int productId) {
        List<Comment> listComment = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.comment.getCommentByProductId);
            ps.setInt(1, productId);
            rs=ps.executeQuery();
            //get all Comment by productId
            while (rs.next()) {
                Comment comment = new Comment(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(5));
                listComment.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listComment;
    }

    public static void main(String[] args) {
        CommentDao cd = new CommentDao();
        List<Comment> lc = cd.getListCommentByProductId(1);
     //   for (Comment comment : lc) {
            System.out.println(lc.size());
      //  }
    }

}
