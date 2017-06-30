package br.com.upis.webgames.entidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Carrinho {

	public Carrinho() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private List<ItemDeCompra> itens;
	private double total;

	public void addNovoItem(ItemDeCompra item) {
		if (this.itens == null) {
			this.itens = new ArrayList<ItemDeCompra>();
		}
		this.itens.add(item);
	}

	public void removerItem(ItemDeCompra itemRemove) {
		for (Iterator i = itens.iterator(); i.hasNext();) {
			ItemDeCompra item = (ItemDeCompra) i.next();
			if (item.getProduto().getId() == itemRemove.getProduto().getId()) {
				i.remove();
			}
		}
	}

	public double calculaTotal() {
		double vtotal = 0;
		for (ItemDeCompra item : this.itens) {
			vtotal += item.getTotal();
		}
		this.total = vtotal;
		return total;
	}

	public Integer getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public List<ItemDeCompra> getItens() {
		return itens;
	}

}
