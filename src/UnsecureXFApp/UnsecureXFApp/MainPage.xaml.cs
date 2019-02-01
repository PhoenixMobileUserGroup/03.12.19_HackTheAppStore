using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace UnsecureXFApp
{
    public partial class MainPage : ContentPage
    {
        private const string SECURE_STRING = "JcVm98d*=R+ffY9CQ&arr7T92ZoNH27ccQUZJ^,*9Jn7A(}UT.qMf";

        public MainPage()
        {
            InitializeComponent();
        }

        void Handle_Clicked(object sender, System.EventArgs e)
        {
            bool isValid = editValidation.Text == SECURE_STRING;
            txtResult.Text = isValid ? "Valid!" : "Invalid!";
        }
    }
}
