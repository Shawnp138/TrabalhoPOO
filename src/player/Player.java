package player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import projectile.Projectile;

/**
 * A classe Player representa o jogador no mini-game. 
 * O jogador é um objeto que pode se mover em diferentes direções 
 * e disparar projéteis.
 */
public class Player {

    // A imagem visual do jogador, representada por um ImageView.
    private ImageView playerImage;

    // Velocidade de movimento do jogador.
    private double moveSpeed = 1.0;

    // Imagens que representam diferentes estados do jogador.
    private Image idleImage = new Image(getClass().getResource("/graphics/slime_idle.png").toExternalForm());
    private Image moveUpImage = new Image(getClass().getResource("/graphics/slime_move_up.png").toExternalForm());
    private Image moveDownImage = new Image(getClass().getResource("/graphics/slime_move_down.png").toExternalForm());
    private Image moveLeftImage = new Image(getClass().getResource("/graphics/slime_move_left.png").toExternalForm());
    private Image moveRightImage = new Image(getClass().getResource("/graphics/slime_move_right.png").toExternalForm());
    private Image shootImage = new Image(getClass().getResource("/graphics/slime_shoot.png").toExternalForm());

    // Última direção que o jogador se moveu, em graus.
    private double lastDirection = 0;

    /**
     * Construtor da classe Player.
     * 
     * @param x Posição inicial X do jogador.
     * @param y Posição inicial Y do jogador.
     * @param width Largura do jogador.
     * @param height Altura do jogador.
     */
    public Player(double x, double y, double width, double height) {
        // Inicializa o ImageView do jogador com a imagem de idle.
        playerImage = new ImageView(idleImage);
        playerImage.setFitWidth(width);
        playerImage.setFitHeight(height);
        playerImage.setX(x);
        playerImage.setY(y);
    }

    /**
     * Move o jogador para cima, atualiza a imagem para a animação de movimento para cima
     * e registra a direção do movimento.
     */
    public void moveUp() {
        playerImage.setY(playerImage.getY() - moveSpeed);
        playerImage.setImage(moveUpImage);
        lastDirection = 270; 
    }

    /**
     * Move o jogador para baixo, atualiza a imagem para a animação de movimento para baixo
     * e registra a direção do movimento.
     */
    public void moveDown() {
        playerImage.setY(playerImage.getY() + moveSpeed);
        playerImage.setImage(moveDownImage);
        lastDirection = 90;
    }

    /**
     * Move o jogador para a esquerda, atualiza a imagem para a animação de movimento para a esquerda
     * e registra a direção do movimento.
     */
    public void moveLeft() {
        playerImage.setX(playerImage.getX() - moveSpeed);
        playerImage.setImage(moveLeftImage);
        lastDirection = 180;
    }

    /**
     * Move o jogador para a direita, atualiza a imagem para a animação de movimento para a direita
     * e registra a direção do movimento.
     */
    public void moveRight() {
        playerImage.setX(playerImage.getX() + moveSpeed);
        playerImage.setImage(moveRightImage);
        lastDirection = 0;
    }

    /**
     * Dispara um projétil na direção atual do jogador e atualiza a imagem do jogador
     * para a animação de disparo.
     * 
     * @return Um objeto Projectile que representa o projétil disparado.
     */
    public Projectile shoot() {
        // Atualiza a imagem do jogador para a animação de disparo.
        playerImage.setImage(shootImage);
        // Cria um novo projétil na posição do jogador, no centro do ImageView, 
        // e na última direção em que o jogador se moveu.
        return new Projectile(playerImage.getX() + playerImage.getFitWidth() / 2, 
                              playerImage.getY() + playerImage.getFitHeight() / 2, 
                              lastDirection);
    }

    /**
     * Para o movimento do jogador, definindo a imagem de volta para a animação de idle.
     */
    public void stop() {
        playerImage.setImage(idleImage);
    }

    /**
     * Retorna a imagem do jogador para que ela possa ser adicionada à cena do jogo.
     * 
     * @return O objeto ImageView que representa o jogador.
     */
    public ImageView getPlayerImage() {
        return playerImage;
    }
}
