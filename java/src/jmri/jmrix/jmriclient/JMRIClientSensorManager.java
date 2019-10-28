package jmri.jmrix.jmriclient;

import jmri.Sensor;

import javax.annotation.Nonnull;

/**
 * Implement sensor manager for JMRIClient systems.
 * <p>
 * System names are "prefixnnn", where prefix is the system prefix and nnn is
 * the sensor number without padding.
 *
 * @author Paul Bender Copyright (C) 2010
 */
public class JMRIClientSensorManager extends jmri.managers.AbstractSensorManager {

    public JMRIClientSensorManager(JMRIClientSystemConnectionMemo memo) {
        super(memo);
    }

    /**
     * {@inheritDoc}
     */
    @Nonnull
    @Override
    public JMRIClientSystemConnectionMemo getMemo() {
        return (JMRIClientSystemConnectionMemo) memo;
    }

    @Nonnull
    @Override
    public Sensor createNewSensor(@Nonnull String systemName, String userName) {
        Sensor t;
        int addr = Integer.parseInt(systemName.substring(getSystemNamePrefix().length()));
        t = new JMRIClientSensor(addr, getMemo());
        t.setUserName(userName);
        return t;
    }

    /*
     * JMRIClient Sensors can take arbitrary names to match the names used
     * on the server.
     */
    @Nonnull
    @Override
    public String createSystemName(@Nonnull String curAddress, @Nonnull String prefix) throws jmri.JmriException {
        return prefix + typeLetter() + curAddress;
    }

}
