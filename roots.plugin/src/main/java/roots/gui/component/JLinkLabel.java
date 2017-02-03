package roots.gui.component;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

public class JLinkLabel extends JLabel implements MouseListener
{
	private static final long serialVersionUID = -8755088363961559289L;

	private URI uri;

	public JLinkLabel(String uri)
	{
		try
		{
			this.uri = new URI(uri);
		} catch (URISyntaxException e)
		{

		}
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addMouseListener(this);

		super.setText(toString());
	}

	public String toString()
	{
		return "<html><font color=#0000ff>&lt;" + this.uri.toString() + "&gt;</font></html>";
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (!Desktop.isDesktopSupported())
		{
			return;
		}

		Runnable run = new Runnable()
		{
			@Override
			public void run()
			{
				Desktop desktop = Desktop.getDesktop();

				try
				{
					desktop.browse(uri);
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
				}
			}

		};

		Thread t = new Thread(run);

		t.start();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
