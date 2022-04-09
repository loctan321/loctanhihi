namespace AS_PRN192
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.dgv = new System.Windows.Forms.DataGridView();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.date_NgaySinh = new System.Windows.Forms.DateTimePicker();
            this.cbx_GioiTinh = new System.Windows.Forms.ComboBox();
            this.tb_MaKhoa = new System.Windows.Forms.TextBox();
            this.tb_TenSV = new System.Windows.Forms.TextBox();
            this.tb_HoSV = new System.Windows.Forms.TextBox();
            this.tb_MaSV = new System.Windows.Forms.TextBox();
            this.label12 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.bt_add = new System.Windows.Forms.Button();
            this.bt_refresh = new System.Windows.Forms.Button();
            this.bt_edit = new System.Windows.Forms.Button();
            this.bt_remove = new System.Windows.Forms.Button();
            this.btn_exit = new System.Windows.Forms.Button();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).BeginInit();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.dgv);
            this.groupBox3.Location = new System.Drawing.Point(4, 13);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(679, 235);
            this.groupBox3.TabIndex = 0;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Information";
            // 
            // dgv
            // 
            this.dgv.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv.Location = new System.Drawing.Point(6, 21);
            this.dgv.Name = "dgv";
            this.dgv.RowTemplate.Height = 24;
            this.dgv.Size = new System.Drawing.Size(665, 208);
            this.dgv.TabIndex = 0;
            this.dgv.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgv_CellContentClick);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.date_NgaySinh);
            this.groupBox4.Controls.Add(this.cbx_GioiTinh);
            this.groupBox4.Controls.Add(this.tb_MaKhoa);
            this.groupBox4.Controls.Add(this.tb_TenSV);
            this.groupBox4.Controls.Add(this.tb_HoSV);
            this.groupBox4.Controls.Add(this.tb_MaSV);
            this.groupBox4.Controls.Add(this.label12);
            this.groupBox4.Controls.Add(this.label11);
            this.groupBox4.Controls.Add(this.label10);
            this.groupBox4.Controls.Add(this.label9);
            this.groupBox4.Controls.Add(this.label8);
            this.groupBox4.Controls.Add(this.label7);
            this.groupBox4.Location = new System.Drawing.Point(4, 255);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(527, 246);
            this.groupBox4.TabIndex = 1;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Data";
            // 
            // date_NgaySinh
            // 
            this.date_NgaySinh.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.date_NgaySinh.Location = new System.Drawing.Point(369, 82);
            this.date_NgaySinh.Name = "date_NgaySinh";
            this.date_NgaySinh.Size = new System.Drawing.Size(111, 22);
            this.date_NgaySinh.TabIndex = 11;
            // 
            // cbx_GioiTinh
            // 
            this.cbx_GioiTinh.FormattingEnabled = true;
            this.cbx_GioiTinh.Items.AddRange(new object[] {
            "Nam",
            "Nữ"});
            this.cbx_GioiTinh.Location = new System.Drawing.Point(369, 34);
            this.cbx_GioiTinh.Name = "cbx_GioiTinh";
            this.cbx_GioiTinh.Size = new System.Drawing.Size(86, 24);
            this.cbx_GioiTinh.TabIndex = 10;
            // 
            // tb_MaKhoa
            // 
            this.tb_MaKhoa.Location = new System.Drawing.Point(91, 177);
            this.tb_MaKhoa.Name = "tb_MaKhoa";
            this.tb_MaKhoa.Size = new System.Drawing.Size(155, 22);
            this.tb_MaKhoa.TabIndex = 9;
            // 
            // tb_TenSV
            // 
            this.tb_TenSV.Location = new System.Drawing.Point(91, 129);
            this.tb_TenSV.Name = "tb_TenSV";
            this.tb_TenSV.Size = new System.Drawing.Size(155, 22);
            this.tb_TenSV.TabIndex = 8;
            // 
            // tb_HoSV
            // 
            this.tb_HoSV.Location = new System.Drawing.Point(91, 84);
            this.tb_HoSV.Name = "tb_HoSV";
            this.tb_HoSV.Size = new System.Drawing.Size(155, 22);
            this.tb_HoSV.TabIndex = 7;
            // 
            // tb_MaSV
            // 
            this.tb_MaSV.Location = new System.Drawing.Point(91, 34);
            this.tb_MaSV.Name = "tb_MaSV";
            this.tb_MaSV.Size = new System.Drawing.Size(155, 22);
            this.tb_MaSV.TabIndex = 6;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(25, 180);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(64, 17);
            this.label12.TabIndex = 5;
            this.label12.Text = "Ma Khoa";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(26, 84);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(48, 17);
            this.label11.TabIndex = 4;
            this.label11.Text = "Ho SV";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(25, 129);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(55, 17);
            this.label10.TabIndex = 3;
            this.label10.Text = "Ten SV";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(290, 84);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(38, 17);
            this.label9.TabIndex = 2;
            this.label9.Text = "DOB";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(290, 37);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(56, 17);
            this.label8.TabIndex = 1;
            this.label8.Text = "Gender";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(25, 37);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(49, 17);
            this.label7.TabIndex = 0;
            this.label7.Text = "Ma SV";
            // 
            // bt_add
            // 
            this.bt_add.Location = new System.Drawing.Point(580, 254);
            this.bt_add.Name = "bt_add";
            this.bt_add.Size = new System.Drawing.Size(75, 41);
            this.bt_add.TabIndex = 2;
            this.bt_add.Text = "Add";
            this.bt_add.UseVisualStyleBackColor = true;
            this.bt_add.Click += new System.EventHandler(this.bt_add_Click);
            // 
            // bt_refresh
            // 
            this.bt_refresh.Location = new System.Drawing.Point(580, 395);
            this.bt_refresh.Name = "bt_refresh";
            this.bt_refresh.Size = new System.Drawing.Size(75, 41);
            this.bt_refresh.TabIndex = 3;
            this.bt_refresh.Text = "Refresh";
            this.bt_refresh.UseVisualStyleBackColor = true;
            this.bt_refresh.Click += new System.EventHandler(this.bt_refresh_Click);
            // 
            // bt_edit
            // 
            this.bt_edit.Location = new System.Drawing.Point(580, 348);
            this.bt_edit.Name = "bt_edit";
            this.bt_edit.Size = new System.Drawing.Size(75, 41);
            this.bt_edit.TabIndex = 4;
            this.bt_edit.Text = "Edit";
            this.bt_edit.UseVisualStyleBackColor = true;
            this.bt_edit.Click += new System.EventHandler(this.bt_edit_Click);
            // 
            // bt_remove
            // 
            this.bt_remove.Location = new System.Drawing.Point(580, 301);
            this.bt_remove.Name = "bt_remove";
            this.bt_remove.Size = new System.Drawing.Size(75, 41);
            this.bt_remove.TabIndex = 5;
            this.bt_remove.Text = "Delete";
            this.bt_remove.UseVisualStyleBackColor = true;
            this.bt_remove.Click += new System.EventHandler(this.bt_remove_Click);
            // 
            // btn_exit
            // 
            this.btn_exit.Location = new System.Drawing.Point(580, 442);
            this.btn_exit.Name = "btn_exit";
            this.btn_exit.Size = new System.Drawing.Size(75, 41);
            this.btn_exit.TabIndex = 6;
            this.btn_exit.Text = "Exit";
            this.btn_exit.UseVisualStyleBackColor = true;
            this.btn_exit.Click += new System.EventHandler(this.btn_exit_Click);
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(684, 506);
            this.Controls.Add(this.btn_exit);
            this.Controls.Add(this.bt_remove);
            this.Controls.Add(this.bt_edit);
            this.Controls.Add(this.bt_refresh);
            this.Controls.Add(this.bt_add);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox3);
            this.Name = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).EndInit();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cbx_gender;
        private System.Windows.Forms.DateTimePicker dob;
        private System.Windows.Forms.TextBox txt_MaKhoa;
        private System.Windows.Forms.TextBox txt_TenSV;
        private System.Windows.Forms.TextBox txt_HoSV;
        private System.Windows.Forms.TextBox txt_MaSV;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button btn_add;
        private System.Windows.Forms.Button btn_implement;
        private System.Windows.Forms.Button btn_edit;
        private System.Windows.Forms.Button btn_remove;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.DataGridView dgv;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.DateTimePicker date_NgaySinh;
        private System.Windows.Forms.ComboBox cbx_GioiTinh;
        private System.Windows.Forms.TextBox tb_MaKhoa;
        private System.Windows.Forms.TextBox tb_TenSV;
        private System.Windows.Forms.TextBox tb_HoSV;
        private System.Windows.Forms.TextBox tb_MaSV;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Button bt_add;
        private System.Windows.Forms.Button bt_refresh;
        private System.Windows.Forms.Button bt_edit;
        private System.Windows.Forms.Button bt_remove;
        private System.Windows.Forms.Button btn_exit;
    }
}

