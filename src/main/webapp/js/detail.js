function recharge(credit) {
    var charge = confirm("你的积分为" + credit + "，不足100，是否充值？");
    if (charge) {
        location = "/recharge.jsp";
    }
}