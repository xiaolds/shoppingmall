package com.datasure.login.util;

public class UserState {
	
	//��½�ɹ� ---> ��½����
	public static final int LOGIN = 3000;
	//ע��ɹ� ---> ע�����
	public static final int SIGNUP = 3001;
	//ע���ɹ� ---> ע������
	public static final int LOGOUT = 3002;
	//���� --->�ж��Ƿ�����
	public static final int ONLINE = 3003;
	
	
	//��½ʧ��
	public static final int NO_SUCH_USER = 30001;			//���û�������
	public static final int PWD_NOT_CRT = 30002;			//���벻��ȷ
	public static final int ACCOUNT_FORBIDDEN = 30003;		//�˻�������
	
	//ע��ʧ��
	public static final int NICKNAME_EXIST = 30011;			//�ǳ��Ѿ�����
	public static final int EMAIL_EXIST = 30012;			//email�Ѿ�����
	public static final int PHONE_EXIT = 30013;				//�ֻ������Ѿ�����
	
	public static final int NICKNAME_NOT_EXIT = 30014;		//�ǳ�δ��ռ��
	public static final int EMAIL_NOT_EXIST = 30015;		//emailδ��ռ��
	public static final int PHONE_NOT_EXIT = 30016;			//�ֻ�δ��ռ��
	
	//������
	public static final int OUTLINE = 30031;				//�û�������
}
