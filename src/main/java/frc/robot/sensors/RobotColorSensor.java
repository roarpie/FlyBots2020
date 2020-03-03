package frc.robot.sensors;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.util.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class RobotColorSensor {
  private ColorSensorV3 colorSensor;
  private ColorMatch colorMatcher;
  private List<ColorType> listOfColorsFound;
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  private HashMap<Color, ColorType> colorMap;

  public enum ColorType {
    RED,
    GREEN,
    BLUE,
    YELLOW,
  }

  public RobotColorSensor(ColorSensorV3 colorSensorV3) {
    this.colorSensor = colorSensorV3;
    colorMatcher = new ColorMatch();

    listOfColorsFound = new ArrayList<>();
    colorMap = new HashMap<>();

    setColorMatchers();
    setColorMap();
  }

  public ColorType getCurrentColorType() {
    Color detectedColor = colorSensor.getColor();
    var matchedColorResult = colorMatcher.matchClosestColor(detectedColor);
    ColorType matchedColorType = colorMap.get(matchedColorResult.color);
    listOfColorsFound.add(matchedColorType);
    return colorMap.get(matchedColorResult.color);
  }

  private void setColorMap() {
    colorMap.put(kBlueTarget, ColorType.BLUE);
    colorMap.put(kGreenTarget, ColorType.GREEN);
    colorMap.put(kRedTarget, ColorType.RED);
    colorMap.put(kYellowTarget, ColorType.YELLOW);
  }

  private void setColorMatchers() {
    colorMatcher.addColorMatch(kBlueTarget);
    colorMatcher.addColorMatch(kGreenTarget);
    colorMatcher.addColorMatch(kRedTarget);
    colorMatcher.addColorMatch(kYellowTarget);
  }
}