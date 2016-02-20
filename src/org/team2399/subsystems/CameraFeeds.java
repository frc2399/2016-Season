package org.team2399.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraFeeds extends Subsystem
{
	private boolean cameraSwitchButtStatus = false;

	public final int cam0;
	public final int cam1;

	private int currentCamera;
	private Image frame;

	private CameraServer server;
	private Joystick joystick;

	public CameraFeeds()
	{
		/*
		 * IMAGE_U8(0), The image type is 8-bit unsigned integer grayscale.
		 * IMAGE_U16(7), The image type is 16-bit unsigned integer grayscale.
		 * IMAGE_I16(1), The image type is 16-bit signed integer grayscale.
		 * IMAGE_SGL(2), The image type is 32-bit floating-point grayscale.
		 * IMAGE_COMPLEX(3), The image type is complex.
		 * IMAGE_RGB(4), The image type is RGB color.
		 * IMAGE_HSL(5), The image type is HSL color.
		 * IMAGE_RGB_U64(6), The image type is 64-bit unsigned RGB color.
		 */
		// consider putting this in greyscale
		cam0 = NIVision.IMAQdxOpenCamera("cam0",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		cam1 = NIVision.IMAQdxOpenCamera("cam1",
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		currentCamera = cam0;

		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_SGL, 0);
		server = CameraServer.getInstance();
		server.setQuality(25);

	}

	public void switchToCameraOne()
	{
		changeCam(cam1);
		updateCam();
	}

	public void switchToCameraZero()
	{
		changeCam(cam0);
		updateCam();
	}

	public void changeCam(int newId)
	{
		NIVision.IMAQdxStopAcquisition(currentCamera);
		NIVision.IMAQdxConfigureGrab(newId);
		NIVision.IMAQdxStartAcquisition(newId);
		currentCamera = newId;
	}

	public void updateCam()
	{
		NIVision.IMAQdxGrab(currentCamera, frame, 1);
		server.setImage(frame);
	}

	/**
	 * Stop aka close camera stream
	 */
	public void end()
	{
		NIVision.IMAQdxStopAcquisition(currentCamera);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
