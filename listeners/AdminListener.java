package listeners;

import java.awt.Event;
import java.util.logging.Logger;
import minigames.Config;
import minigames.MiniGames;
import minigames.PlayerChecks;
import minigames.Status;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * FireLord 0.4
 * Copyright (C) 2011 W4rGo , Francisco Ruiz Valdes <franrv@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
public class AdminListener extends PlayerListener {

    public static final Logger log = Logger.getLogger("Minecraft");
    public static MiniGames plugin = null;

    public AdminListener(MiniGames minigames) {
        plugin = minigames;
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        super.onPlayerInteract(event);
        Player player = event.getPlayer();

        if (player.getItemInHand().getTypeId() == Config.getGetWandId()) {

            if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                //select 1 block
                Status.setSelectedBlock1(event.getClickedBlock());
                player.sendMessage("Block 1 Selected");

            } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                //select 2 block
                Status.setSelectedBlock2(event.getClickedBlock());
                player.sendMessage("Block 2 Selected");
                
            }

            if ((Status.getSelectedBlock1() != null) && (Status.getSelectedBlock2() != null)) {
                player.sendMessage("Region selected : " + PlayerChecks.calculateCuboid(Status.getSelectedBlock1(), Status.getSelectedBlock2()));
            }
        }

    }
}
