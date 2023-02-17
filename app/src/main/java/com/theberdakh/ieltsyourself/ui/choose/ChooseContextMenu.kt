package com.theberdakh.ieltsyourself.ui.choose

import android.content.ComponentName
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.*
import com.theberdakh.ieltsyourself.R

class ChooseContextMenu: ContextMenu {
    override fun add(p0: CharSequence?): MenuItem {
        return getItem(
            R.id.action_top_topic
        )
    }

    override fun add(p0: Int): MenuItem {
        TODO("Not yet implemented")
    }

    override fun add(p0: Int, p1: Int, p2: Int, p3: CharSequence?): MenuItem {
        TODO("Not yet implemented")
    }

    override fun add(p0: Int, p1: Int, p2: Int, p3: Int): MenuItem {
        TODO("Not yet implemented")
    }

    override fun addSubMenu(p0: CharSequence?): SubMenu {
        TODO("Not yet implemented")
    }

    override fun addSubMenu(p0: Int): SubMenu {
        TODO("Not yet implemented")
    }

    override fun addSubMenu(p0: Int, p1: Int, p2: Int, p3: CharSequence?): SubMenu {
        TODO("Not yet implemented")
    }

    override fun addSubMenu(p0: Int, p1: Int, p2: Int, p3: Int): SubMenu {
        TODO("Not yet implemented")
    }

    override fun addIntentOptions(
        p0: Int,
        p1: Int,
        p2: Int,
        p3: ComponentName?,
        p4: Array<out Intent>?,
        p5: Intent?,
        p6: Int,
        p7: Array<out MenuItem>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun removeItem(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun removeGroup(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun setGroupCheckable(p0: Int, p1: Boolean, p2: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setGroupVisible(p0: Int, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setGroupEnabled(p0: Int, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun hasVisibleItems(): Boolean {
        TODO("Not yet implemented")
    }

    override fun findItem(p0: Int): MenuItem {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): MenuItem {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun performShortcut(p0: Int, p1: KeyEvent?, p2: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun isShortcutKey(p0: Int, p1: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun performIdentifierAction(p0: Int, p1: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun setQwertyMode(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setHeaderTitle(p0: Int): ContextMenu {
        TODO("Not yet implemented")
    }

    override fun setHeaderTitle(p0: CharSequence?): ContextMenu {
        TODO("Not yet implemented")
    }

    override fun setHeaderIcon(p0: Int): ContextMenu {
        TODO("Not yet implemented")
    }

    override fun setHeaderIcon(p0: Drawable?): ContextMenu {
        TODO("Not yet implemented")
    }

    override fun setHeaderView(p0: View?): ContextMenu {
        TODO("Not yet implemented")
    }

    override fun clearHeader() {
        TODO("Not yet implemented")
    }
}