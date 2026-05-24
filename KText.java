import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

/**
 * テキスト
 * <pre>
 * テキストを表示するオブジェクト。
 * </pre>
 */
public class KText {

	/** フォント */
	private Font font = new Font("ＭＳ ゴシック", Font.PLAIN, 12);

	/** パネル */
	protected KPanel panel = null;

	/** X座標 */
	protected int intX = 0;

	/** Y座標 */
	protected int intY = 0;

	/** 前景色 */
	private Color colorForeground = Color.white;

	/** 文字列 */
	private String strText = null;

	/**
	 * コンストラクタ
	 * @param panel パネル
	 * @param intX 表示位置。X座標。
	 * @param intY 表示位置。Y座標。
	 */
	public KText(KPanel panel, int intX, int intY){

		this(panel, intX, intY, Color.white);

	} // end KText

	/**
	 * コンストラクタ
	 * @param panel パネル
	 * @param intX 表示位置。X座標。
	 * @param intY 表示位置。Y座標。
	 * @param colorForeground 前景色
	 */
	public KText(KPanel panel, int intX, int intY, Color colorForeground){

		super();

		this.panel = panel;

		this.intX = intX;

		this.intY = intY;

		this.colorForeground = colorForeground;

	} // end KText

	/**
	 * スプライト描画
	 * <pre>
	 * 表示の必要があれば実行される。
	 * </pre>
	 */
	public void paint(Graphics g){

		// 文字列がnull以外の場合、
		if(strText != null){

			// フォント
			g.setFont(font);
			// 色
			g.setColor(this.colorForeground);

			// 文字列を表示
			g.drawString(strText, intX, intY);

		} // end if 文字列がnull以外の場合

	} // end paint

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

	}

	/**
	 * X座標取得
	 */
	public int getX(){
		return this.intX;
	}

	/**
	 * X座標設定
	 */
	public void setX(int x){
		this.intX = x;
	}

	/**
	 * Y座標取得
	 */
	public int getY(){
		return this.intY;
	}

	/**
	 * Y座標設定
	 */
	public void setY(int y){
		this.intY = y;
	}

	/**
	 * 文字列設定
	 * @param strText 文字列
	 */
	public void setText(String strText){
		// 文字列設定
		this.strText = strText;
	}

	/**
	 * 文字列取得
	 */
	public String getText(){
		// 文字列をリターン
		return strText;
	}

	/**
	 * 前景色設定
	 * @param color 前景色
	 */
	public void setForeground(Color color){
		// 文字列設定
		this.colorForeground = color;
	}

	/**
	 * フォント設定
	 * @param font フォント
	 */
	public void setFont(Font font){
		// 文字列設定
		this.font = font;
	}

	/**
	 * パネル取得
	 */
	public KPanel getKPanel(){
		return panel;
	}

}
