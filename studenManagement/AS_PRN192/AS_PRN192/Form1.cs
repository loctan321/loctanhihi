using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Text.RegularExpressions;

namespace AS_PRN192
{
    public partial class Form1 : Form
    {
        SqlConnection connection;
        SqlCommand command;
        String str = @"Data Source=SE140439\SQLEXPRESS;Initial Catalog=QLSVien;Integrated Security=True";
        SqlDataAdapter adapter = new SqlDataAdapter();
        DataTable table = new DataTable();

        void loadData()
        {
            command = connection.CreateCommand();
            command.CommandText = " SELECT * from SinhVien ";
            adapter.SelectCommand = command;
            table.Clear();
            adapter.Fill(table);
            dgv.DataSource = table;
            dgv.ClearSelection();
        }
        

        void refresh2()
        {
            tb_MaSV.ReadOnly = false;
            bt_add.Enabled = true;
            tb_MaSV.Text = "";
            tb_HoSV.Text = "";
            tb_TenSV.Text = "";
            tb_MaKhoa.Text = "";
            cbx_GioiTinh.Text = "";
            date_NgaySinh.Text = "";
            dgv.ClearSelection();
            bt_edit.Enabled = false;
            bt_remove.Enabled = false;
        }

        void checkDuplicated()
        {
            
            SqlCommand checkValidatedID = new SqlCommand("Select Convert(Varchar(10), MaSV) from SinhVien where Convert(Varchar(10), MaSV)='" + tb_MaSV.Text + "'", connection);
            String flag = (String)checkValidatedID.ExecuteScalar();
            if (flag == tb_MaSV.Text)
            {
                MessageBox.Show("Duplicated ID.");
                tb_MaSV.Focus();
            }
            
        }


        public Form1()
        {
            InitializeComponent();      
            bt_edit.Enabled = false;
            bt_remove.Enabled = false;  
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            connection = new SqlConnection(str);
            connection.Open();
            loadData();
        }

        private void dgv_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            tb_MaSV.ReadOnly = true;
            int row;
            row = dgv.CurrentRow.Index;
            tb_MaSV.Text = dgv.Rows[row].Cells[0].Value.ToString();
            tb_HoSV.Text = dgv.Rows[row].Cells[1].Value.ToString();
            tb_TenSV.Text = dgv.Rows[row].Cells[2].Value.ToString();
            date_NgaySinh.Text = dgv.Rows[row].Cells[3].Value.ToString();
            cbx_GioiTinh.Text = dgv.Rows[row].Cells[4].Value.ToString();
            tb_MaKhoa.Text = dgv.Rows[row].Cells[5].Value.ToString();
            bt_add.Enabled = false;
            bt_edit.Enabled = true;
            bt_remove.Enabled = true;

        }


        private void bt_add_Click(object sender, EventArgs e)
        {
            checkDuplicated();

            if (tb_MaSV.Text.Trim() == "")
            {
                MessageBox.Show("Ma SV is empty!");
                tb_MaSV.Focus();
            }
            else if(!Regex.Match(tb_MaSV.Text, @"^[SE]{2}[0-9]{4}").Success)
            {
                MessageBox.Show("Wrong format. ID must be filled in as SE****");
                tb_MaSV.Focus();
            }
            else if(tb_HoSV.Text.Trim() == "")
            {
                MessageBox.Show("Ho SV is empty!");
                tb_HoSV.Focus();
            }
            else if (tb_TenSV.Text.Trim() == "")
            {
                MessageBox.Show("Ten SV is empty!");
                tb_TenSV.Focus();
            }
            else if (tb_MaKhoa.Text.Trim() == "")
            {
                MessageBox.Show("Ma Khoa is empty!");
                tb_MaKhoa.Focus();
            }
            else if (cbx_GioiTinh.SelectedItem ==null)
            {
                MessageBox.Show("Gender is empty!");
                cbx_GioiTinh.Focus();
            }
            else
            {
                command = connection.CreateCommand();
                command.CommandText = "insert into SinhVien values ('" + tb_MaSV.Text + "', '" + tb_HoSV.Text + "', '" + tb_TenSV.Text + "', '" + date_NgaySinh.Text + "', N'" + cbx_GioiTinh.Text + "', '" + tb_MaKhoa.Text + "')";
                command.ExecuteNonQuery();
                loadData();
                MessageBox.Show("Add successfully!");
                refresh2();
            }
            
        }

        private void bt_remove_Click(object sender, EventArgs e)
        {
            command = connection.CreateCommand();
            command.CommandText = "delete from SinhVien where MaSV= '"+tb_MaSV.Text+"'";
            command.ExecuteNonQuery();
            loadData();
            MessageBox.Show("Delete successfully!");
            refresh2();
        }

        private void bt_edit_Click(object sender, EventArgs e)
        {
            
            if (tb_HoSV.Text.Trim() == "")
            {
                MessageBox.Show("Ho SV is empty!");
                tb_HoSV.Focus();
            }
            else if (tb_TenSV.Text.Trim() == "")
            {
                MessageBox.Show("Ten SV is empty!");
                tb_TenSV.Focus();
            }
            else if (tb_MaKhoa.Text.Trim() == "")
            {
                MessageBox.Show("Ma Khoa is empty!");
                tb_MaKhoa.Focus();
            }
      
            else
            {
                command = connection.CreateCommand();
                command.CommandText = " update SinhVien set HoSV= N'" + tb_HoSV.Text + "', TenSV= N'" + tb_TenSV.Text + "', NgaySinh='" + date_NgaySinh.Text + "', GioiTinh= N'" + cbx_GioiTinh.Text + "', MaKhoa='" + tb_MaKhoa.Text + "' where MaSV= '" + tb_MaSV.Text + "'";
                command.ExecuteNonQuery();
                MessageBox.Show("Edit successfully!");
                loadData();
            }
        }

        private void bt_refresh_Click(object sender, EventArgs e)
        {
            tb_MaSV.ReadOnly = false;
            bt_add.Enabled = true;
            bt_edit.Enabled = false;
            bt_remove.Enabled = false;
            tb_MaSV.Text = "";
            tb_HoSV.Text = "";
            tb_TenSV.Text= "";
            tb_MaKhoa.Text="";
            cbx_GioiTinh.Text= "";
            date_NgaySinh.Text= "";
            dgv.ClearSelection();
        }

        private void btn_exit_Click(object sender, EventArgs e)
        {
            DialogResult f = MessageBox.Show("Bạn có thật sự muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Warning);
            if (f == DialogResult.Yes)
            {
                Application.Exit();
            }          
        }
    }
}
