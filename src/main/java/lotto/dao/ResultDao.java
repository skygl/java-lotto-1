package lotto.dao;

import lotto.dto.ResultDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDao {
    private Connection con;

    public ResultDao(Connection con) {
        this.con = con;
    }

    public void addResult(ResultDto resultDto) throws SQLException {
        String query = "INSERT INTO 회차별결과 (회차, 총구입금액, 총당첨금액) VALUES (?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, findRoundNo());
        pstmt.setInt(2, resultDto.getTotalPurchaseMoney());
        pstmt.setString(3, resultDto.getTotalWinningMoney().toString());
        pstmt.executeUpdate();
    }

    public int findRoundNo() throws SQLException {
        String query = "SELECT 회차 FROM 당첨로또 ORDER BY 회차 DESC LIMIT 1";
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next())
            return 0;
        return rs.getInt("회차");
    }
}