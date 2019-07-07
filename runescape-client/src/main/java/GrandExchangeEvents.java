import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("g")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("f")
   @Export("geAgeComparator")
   public static Comparator geAgeComparator;
   @ObfuscatedName("q")
   @Export("geUnitPriceComparator")
   public static Comparator geUnitPriceComparator;
   @ObfuscatedName("w")
   @Export("geItemNameComparator")
   public static Comparator geItemNameComparator;
   @ObfuscatedName("o")
   @Export("geTotalQuantityComparator")
   public static Comparator geTotalQuantityComparator;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1605454211
   )
   static int field375;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1326137897
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("m")
   @Export("events")
   public final List events;

   @ObfuscatedSignature(
      signature = "(Lgr;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if (var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for (int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1070318468"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if (var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1601363438"
   )
   @Export("addChatMessage")
   static void addChatMessage(int type, String sender, String text, String prefix) {
      ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(type);
      if (var4 == null) {
         var4 = new ChatChannel();
         Messages.Messages_channels.put(type, var4);
      }

      Message var5 = var4.addMessage(type, sender, text, prefix);
      Messages.Messages_hashTable.put(var5, (long)var5.count);
      Messages.Messages_queue.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method69() {
      HitSplatDefinition.HitSplatDefinition_cached.clear();
      HitSplatDefinition.field385.clear();
      HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "620886402"
   )
   static int method75(int var0, Script var1, boolean var2) {
      Widget var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
      if (var0 == ScriptOpcodes.IF_GETSCROLLX) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETSCROLLY) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETTEXT) {
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETSCROLLWIDTH) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETSCROLLHEIGHT) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETMODELZOOM) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_X) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Z) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETMODELANGLE_Y) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETTRANS) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.transparency;
         return 1;
      } else if (var0 == 2610) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.field960;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETCOLOUR) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if (var0 == ScriptOpcodes.IF_GETFILLCOLOUR) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if (var0 == 2613) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.rectangleMode.rsOrdinal();
         return 1;
      } else if (var0 == 2614) {
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-635606409"
   )
   static final void method74(int var0, int var1) {
      if (GroundItemPile.loadInterface(var0)) {
         class30.method570(Widget.interfaceComponents[var0], var1);
      }

   }

   static {
      geAgeComparator = new GrandExchangeOfferAgeComparator();
      new GrandExchangeOfferWorldComparator();
      geUnitPriceComparator = new GrandExchangeOfferUnitPriceComparator();
      geItemNameComparator = new GrandExchangeOfferNameComparator();
      geTotalQuantityComparator = new GrandExchangeOfferTotalQuantityComparator();
   }
}
