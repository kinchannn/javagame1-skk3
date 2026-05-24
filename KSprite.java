import java.awt.*;
import java.awt.image.*;
import java.util.*;

/**
 * スプライト
 * <pre>
 * スプライトオブジェクト。
 * スプライトの概念を実現。
 * </pre>
 */
abstract public class KSprite extends KSpriteObject {

	/** パネル */
	protected KPanel panel = null;

	/** イメージ・クラス設定 */
	private static HashMap<Class, BufferedImage[]>imageThiss = new HashMap<Class, BufferedImage[]>();

	/** イメージ現在設定 */
	private BufferedImage imageThis = null;

	/** X座標 */
	protected int intX = 0;

	/** Y座標 */
	protected int intY = 0;

	/** 背景色 */
	private Color colorBackground = Color.black;

	/**
	 * コンストラクタ
	 */
	public KSprite(KPanel panel){

		super();

		this.panel = panel;

		// イメージ設定
		this.imageThis = imageThiss.get(this.getClass())[0];

	}

	/**
	 * イメージ・クラス設定
	 */
	public static void setImage(Class theClass, BufferedImage image){
		KSprite.setImage(theClass, new BufferedImage[]{image});
	}

	/**
	 * イメージ・クラス設定（複数）
	 */
	public static void setImage(Class theClass, BufferedImage[] images){
		KSprite.imageThiss.put(theClass, images);
	}

	/**
	 * スプライト描画
	 * <pre>
	 * 表示の必要があれば実行される。
	 * </pre>
	 */
	public void paint(Graphics g){

		// イメージを表示
		g.drawImage(this.imageThis, intX, intY, getWidth(), getHeight(), panel);

	} // end paint

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * </pre>
	 */
	abstract public void run();

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
	 * イメージ取得
	 * @imagePhase イメージフェーズ
	 */
	protected BufferedImage getImage(){
		// イメージ設定
		return this.imageThis;
	}

	/**
	 * イメージ設定
	 * @imagePhase イメージフェーズ
	 */
	public void setImage(int imagePhase){
		// イメージ設定
		this.imageThis = imageThiss.get(this.getClass())[imagePhase];
	}

	/**
	 * イメージ設定
	 * @theClass スプライトクラス 自クラスと違うスプライトを指定する場合は、このメソッドを呼び出す
	 * @imagePhase イメージフェーズ
	 */
	public void setImage(Class theClass, int imagePhase){
		// イメージ設定
		this.imageThis = imageThiss.get(theClass)[imagePhase];
	}

	/**
	 * 幅取得
	 */
	public int getWidth(){
		return imageThiss.get(this.getClass())[0].getWidth(panel);
	}

	/**
	 * 高さ取得
	 */
	public int getHeight(){
		return imageThiss.get(this.getClass())[0].getHeight(panel);
	}

	/**
	 * スプライト削除
	 * <pre>
	 * 自スプライトを削除します。
	 * <pre>
	 */
	public void removeSprite(){

		// スプライトを削除
		panel.removeSprite(this);

	} // end removeSprite

	/**
	 * パネル取得
	 */
	public KPanel getKPanel(){
		return panel;
	}

}
