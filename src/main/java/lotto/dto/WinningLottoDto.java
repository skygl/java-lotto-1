package lotto.dto;

public class WinningLottoDto {
    private int round;
    private String lottoNo;
    private String bonusNo;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getLottoNo() {
        return lottoNo;
    }

    public void setLottoNo(String lottoNo) {
        this.lottoNo = lottoNo;
    }

    public String getBonusNo() {
        return bonusNo;
    }

    public void setBonusNo(String bonusNo) {
        this.bonusNo = bonusNo;
    }
}
