package GUI.Special;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public interface GreyedOutButtons {
    class GreyButtonRenderer extends JButton implements TableCellRenderer {
        public GreyButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            setBackground(Color.lightGray);
            setForeground(Color.gray);
            return this;
        }
    }
}
