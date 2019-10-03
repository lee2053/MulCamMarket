package Client.Frame;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
        JButton jb;
         
        public TableCell(JTable table) {
            // TODO Auto-generated constructor stub
            jb = new JButton("버튼");
             
            jb.addActionListener(e -> {
                System.out.println(table.getValueAt(table.getSelectedRow(), 1));
            });
         
        }
         
        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            return jb;
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            // TODO Auto-generated method stub
            return jb;
        }
    }