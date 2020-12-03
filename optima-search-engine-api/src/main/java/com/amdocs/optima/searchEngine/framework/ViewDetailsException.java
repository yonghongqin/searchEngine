/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amdocs.optima.searchEngine.framework;

/**
 *
 * @author QINY
 */

public class ViewDetailsException  extends RuntimeException
{
	public ViewDetailsException(){}
	public ViewDetailsException(String viewType,Throwable t)
	{
		super(viewType,t);
	}
}
