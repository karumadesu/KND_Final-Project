package main;

import java.awt.*;
import javax.swing.*;

import pellets.PelletManager;
import pellets.Pellets;
import entities.Player;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable{
    public final int tileSize = 64;

    public final int screenColumn = 18;
    public final int screenRow = 12;
    public final int screenWidth = screenColumn * tileSize;
    public final int screenHeight = screenRow * tileSize;

    public final int hardColumn = 50;
    public final int hardRow = 50;
    public final int hardWidth = hardColumn * tileSize;
    public final int hardHeight = hardRow * tileSize;

    public final int framePerSecond = 60;

    public int settingOption = 0;
    public int sliderValue = 0;
    public int iterator = 0;
    public int volumeValue = 281;
    public int sliderPosition = 748;
    public int volumeLevel = 4;
    public int nameFieldNumber = 0;
    public int highlightIterator = 0;
    public int nameFieldX = 518;
    public int level = 0;
    public int pelletCounter = 0;
    public int infoCount = 0;
    public int levelCompleteOption = 0;
    public int playMinute = 0;
    public int leaderboardDifficulty = 0;
    public int leaderboardLevel = 0;
    public int easyProgress = 0;
    public int hardProgress = 0;
    public int loadColumn = 0;
    public int loadRow = 0;
    public int loadedAccount = 0;
    
    public double playSecond = 0;

    public long musicMilliseconds;

    public float splashAlpha = 0.0f;
    public float volume = 1.0f;

    public boolean hasExited = false;
    public boolean exitOption = false;
    public boolean isMuted = false;
    public boolean hasEntered = false;
    public boolean isCompleted = false;
    public boolean hasPlayed = false;
    public boolean hasSelected = false;
    public boolean isTaken = false;
    public boolean showAlert = false;
    public boolean showTrivia = false;
    
    public char[] playerName = {'A', 'A', 'A'};

    public String[][] level1Easy = new String[99][3];
    public String[][] level2Easy = new String[99][3];
    public String[][] level3Easy = new String[99][3];
    public String[][] level1Hard = new String[99][3];
    public String[][] level2Hard = new String[99][3];
    public String[][] level3Hard = new String[99][3];
    public String[][] loadedAccounts = new String[6][3];
    public String[][] factsTrivia = new String[8][2];
    public String[][] fightsTrivia = new String[8][5];

    public String gameState = "Splash Screen";
    public String difficulty = "Easy";

    public String easyMap1 = "/maps/map_1_easy.txt";
    public String easyMap2 = "/maps/map_2_easy.txt";
    public String easyMap3 = "/maps/map_3_easy.txt";
    public String hardMap1 = "/maps/map_1_hard.txt";
    public String hardMap2 = "/maps/map_2_hard.txt";
    public String hardMap3 = "/maps/map_3_hard.txt";

    public String pelletMapEasy1 = "/maps/pellet_map_1_easy.txt";
    public String pelletMapEasy2 = "/maps/pellet_map_2_easy.txt";
    public String pelletMapEasy3 = "/maps/pellet_map_3_easy.txt";
    public String pelletMapHard1 = "/maps/pellet_map_1_hard.txt";
    public String pelletMapHard2 = "/maps/pellet_map_2_hard.txt";
    public String pelletMapHard3 = "/maps/pellet_map_3_hard.txt";

    public Color backgroundColor = Color.decode("#1F1F30");
    
    public KeyEvents keyEvents = new KeyEvents(this);
    public SoundEvents soundEvents = new SoundEvents(this);
    public SoundEvents musicEvents = new SoundEvents(this);
    public SoundEvents levelCompleteSound = new SoundEvents(this);
    public SplashScreen splashScreen = new SplashScreen(this);
    public ExitMenu exitMenu = new ExitMenu(this);
    public Settings settings = new Settings(this);
    public NewGame newGame = new NewGame(this);
    public DifficultySelect difficultySelect = new DifficultySelect(this);
    public LevelSelect levelSelect = new LevelSelect(this);
    public TileManager tileManager = new TileManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public Pellets pellets[] = new Pellets[9999];
    public PelletSetter pelletSetter = new PelletSetter(this);
    public PelletManager pelletManager = new PelletManager(this);
    public UserInterface userInterface = new UserInterface(this);
    public SaveRecords saveRecords = new SaveRecords(this);
    public LoadRecords loadRecords = new LoadRecords(this);
    public LoadAccount loadAccount = new LoadAccount(this);
    public LoadTrivia loadTrivia = new LoadTrivia(this);
    public UserChecker userChecker = new UserChecker(this);
    public LoadGame loadGame = new LoadGame(this);
    public Leaderboards leaderboards = new Leaderboards(this);
    public MainMenu mainMenu = new MainMenu(this, keyEvents);
    public Player player = new Player(this, keyEvents);

    Thread gameThread;

    public GamePanel(){
        this.setBackground(backgroundColor);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.addKeyListener(keyEvents);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double interval = 1000000000 / framePerSecond;
        double nextInterval = System.nanoTime() + interval;

        while(gameThread != null){
            update();
            repaint();

            try{
                double remainingTime = nextInterval - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextInterval += interval;
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
    }

    public void setupGame(){
        loadRecords.loadRecords();
        leaderboards.getRanking();
        loadAccount.loadUsers();
        loadTrivia.loadTrivia();

        playSound(0);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        if(gameState.equals("Splash Screen")){
            splashScreen.draw(graphics);
        }
        else if(gameState.equals("Main Menu")){
            mainMenu.draw(graphics); 
        }
        else if(gameState.equals("New Game")){
            newGame.draw(graphics);
        }
        else if(gameState.equals("Difficulty Select")){
            difficultySelect.draw(graphics);
        }
        else if(gameState.equals("Level Select")){
            levelSelect.draw(graphics);
        }
        else if(gameState.equals("Load Game")){
            loadGame.draw(graphics);
        }
        else if(gameState.equals("Leaderboards")){
            leaderboards.draw(graphics);
        }
        else if(gameState.equals("In Game")){
            tileManager.draw(graphics);

            for(int i = 0; i < pellets.length; i++){
                if(pellets[i] != null){
                    pellets[i].draw(graphics, this);
                }
            }

            player.draw(graphics);
            userInterface.draw(graphics);
        }
        else if(gameState.equals("Settings")){
            mainMenu.draw(graphics);
            settings.draw(graphics);
        }
        else if(gameState.equals("Exit Menu")){
            mainMenu.draw(graphics);
            exitMenu.draw(graphics);
        }
        
        graphics.dispose();
    }

    public void playMusic(int option){
        musicEvents.getAudio(option);
        musicEvents.play();
        musicEvents.loop(option);
    }

    public void stopMusic(){
        musicEvents.stop();
    }

    public void playSound(int option){
        soundEvents.getAudio(option);
        soundEvents.play();
    }

    public void stopSound(){
        soundEvents.stop();
    }

    public void playLevelComplete(){
        levelCompleteSound.getAudio(8);
        levelCompleteSound.play();
    }

    public void stopLevelComplete(){
        levelCompleteSound.stop();
    }
}
