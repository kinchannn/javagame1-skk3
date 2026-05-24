import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * フレーム
 */
public class KFrameSKK extends JFrame implements KConstant {

	KCtrlSKK	kCtrl		= null;
	KPanel		kPanel		= null;

	/**
	 * ここから始まります
	 */
	public static void main(String[] args){
		KFrameSKK test = new KFrameSKK();
	}

	/**
	 * コンストラクタ
	 */
	public KFrameSKK(){

		super();

		super.setSize(KConstant.WIDTH, KConstant.HEIGHT);
		super.setLayout(new BorderLayout());

		KFrameWindowAdapter kfwa = new KFrameWindowAdapter();

		super.addWindowListener(kfwa);
		super.addWindowFocusListener(kfwa);

		KImage.setContainer(this);

		kCtrl = new KCtrlSKK(this);
		kPanel = kCtrl.getKPanel();
		kPanel.setPreferredSize(new Dimension(KConstant.WIDTH, KConstant.HEIGHT));

		super.setTitle("SKK");

		super.setContentPane(kPanel);

		super.pack();

		super.setVisible(true);

		super.requestFocus();
		kPanel.requestFocus();

		kCtrl.start();

	} // end KFrameSKK

	private class KFrameWindowAdapter extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}

		@Override
		public void windowGainedFocus(WindowEvent we){
			kPanel.requestFocus();
		}

	}

}
