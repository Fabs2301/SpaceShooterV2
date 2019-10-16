# SpaceShooterV2
Servus Winkler!


Scene sc;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

bbb

		sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
					right = true;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					left = true;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					down = true;
				} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					up = true;
				} else if (event.getCode() == KeyCode.SHIFT) {
					speed = 9;
				}
			}
		});

		sc.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) { // don't use toString here!!!
					right = false;
				} else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					left = false;
				} else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					down = false;
				} else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					up = false;
				} else if (event.getCode() == KeyCode.SHIFT) {
					speed = 5;
				}
			}
		});
	}
	
	
	