enum class Commands {
    PI_CTRL_SYN_ACK,    // Server: You are now connected - continue
    PI_CTRL_BUSY,       // Server: Someone is already connected - you must disconnect

    PI_CTRL_SYN,        // Client: Request to connect
    PI_CTRL_HEARTBEAT,  // Client: Send heartbeat so server can disconnect if connection is lost
    PI_CTRL_DISCONNECT, // Client: Let server know you are disconnecting

    PI_CTRL_SET_NAME,   // Client: Send current name so server can say who is currently connected on a PI_CTRL_BUSY
    PI_CTRL_MOUSE_MV,   // Client: Send x,y of relative position to move mouse to
    PI_CTRL_MOUSE_DOWN, // Client: Say to press mouse down (no data required)
    PI_CTRL_MOUSE_UP,   // Client: Say to press mouse up (no data required)
    PI_CTRL_MOUSE_CLK,  // Client: Say to click (mouseup, then mousedown) mouse (no data required)
    PI_CTRL_KEY_PRESS,  // Client: Send UTF-8 value of key to be pressed (details TBD)
}