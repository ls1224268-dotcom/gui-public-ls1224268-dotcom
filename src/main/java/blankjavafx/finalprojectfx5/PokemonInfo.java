package blankjavafx.finalprojectfx5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PokemonInfo
{
    public int id;
    public String name;
    public String type;
    public String type2;
    public double height;
    public double weight;
    public String ability;
    public String ability2;
    public String ability3;
    public double hp;
    public double atk;
    public double def;
    public double spatk;
    public double spdef;
    public double spe;


    public static int getID(int targetRow)
    {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 0;
        int currentRow = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return Integer.parseInt(values[targetCol].trim());
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String getName(int targetRow) {
    String path = "pokemonInfo.csv";
    String line;
    int targetCol = 1;
    int currentRow = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        while ((line = br.readLine()) != null) {
            if (currentRow == targetRow) {
                String[] values = line.split(",");
                if (targetCol < values.length) {
                    return values[targetCol].trim();
                }
            }
            currentRow++;
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
    return null;
    }

    public static String getType1(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 2;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getType2(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 3;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHeight(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 4;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getWeight(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 5;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAbility(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 6;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAbility2(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 7;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAbility3(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 8;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHP(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 9;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getATK(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 10;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDEF(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 11;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSPATK(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 12;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSPDEF(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 13;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSPE(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 14;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getGender(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 15;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMega(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 16;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMega2(int targetRow) {
        String path = "pokemonInfo.csv";
        String line;
        int targetCol = 17;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getEntries(int targetRow) {
        String path = "pokemonEntries.csv";
        String line;
        int targetCol = 1;
        int currentRow = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(",");
                    if (targetCol < values.length) {
                        return values[targetCol].trim();
                    }
                }
                currentRow++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAbilityInfo(String targetWord) throws IOException
    {
        String path = "abilityInfo.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(targetWord.toLowerCase())) {
                    int commaIndex = line.indexOf(",");
                    if (commaIndex != -1 && commaIndex < line.length() - 1) {
                        return line.substring(commaIndex + 1).trim();
                    }
                    return "";
                }
            }
        }
        return null;
    }
}