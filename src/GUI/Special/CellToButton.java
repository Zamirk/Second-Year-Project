package GUI.Special;
//****************************
//Created by Zamir on 21/03/2015.
//****************************
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public interface CellToButton {
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
}
