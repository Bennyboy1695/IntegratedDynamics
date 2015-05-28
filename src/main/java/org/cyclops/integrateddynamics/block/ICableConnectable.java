package org.cyclops.integrateddynamics.block;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;
import org.cyclops.integrateddynamics.core.path.IPathElement;
import org.cyclops.integrateddynamics.core.path.IPathElementProvider;

/**
 * Interface for blocks which can connect with cables.
 * @author rubensworks
 */
public interface ICableConnectable<E extends IPathElement<E>> extends IPathElementProvider<E> {

    /**
     * Check if the given position should connect with this.
     * @param world The world.
     * @param selfPosition The position for this block.
     * @param connector The connecting block.
     * @param side The side of the connecting block.
     * @return If it should connect.
     */
    public boolean canConnect(World world, BlockPos selfPosition, ICableConnectable connector, EnumFacing side);

    /**
     * Update the cable connections at the given position.
     * @param world The world.
     * @param pos The position of this block.
     * @return The resulting state.
     */
    public IExtendedBlockState updateConnections(World world, BlockPos pos);

    /**
     * Check if this cable is connected to a side.
     * @param world The world.
     * @param pos The position of this block.
     * @param side The side to check a connection for.
     * @return If this block is connected with that side.
     */
    public boolean isConnected(World world, BlockPos pos, EnumFacing side);

    /**
     * Disconnect the cable connection for a side.
     * @param world The world.
     * @param pos The position of this block.
     * @param side The side to block the connection for.
     */
    public void disconnect(World world, BlockPos pos, EnumFacing side);

    /**
     * Check if this cable has a part on the given side.
     * @param world The world.
     * @param pos The position of this block.
     * @param side The side to check a part for.
     * @return If this block has a part on the given side.
     */
    public boolean hasPart(World world, BlockPos pos, EnumFacing side);

    /**
     * (Re-)initialize the network at the given position.
     * @param world The world.
     * @param pos The position of this block.
     */
    public void initNetwork(World world, BlockPos pos);

    /**
     * @param world The world.
     * @param pos The position of this block.
     * @return If this cable is a real cable, otherwise it is just a holder block for parts without connections.
     */
    public boolean isRealCable(World world, BlockPos pos);

    /**
     * @param world The world.
     * @param pos The position of this block.
     * @param realCable If this cable is a real cable, otherwise it is just a holder block for parts without connections.
     */
    public void setRealCable(World world, BlockPos pos, boolean realCable);

}
