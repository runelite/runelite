import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1849349711
   )
   final int field3838;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 535740751
   )
   @Export("count")
   int count;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lku;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("z")
   HashMap field3837;
   @ObfuscatedName("i")
   HashMap field3840;
   @ObfuscatedName("u")
   Comparator field3842;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3842 = null;
      this.field3838 = var1;
      this.nameables = this.vmethod5462(var1);
      this.field3837 = new HashMap(var1 / 8);
      this.field3840 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lku;",
      garbageValue = "52"
   )
   abstract Nameable vmethod5454();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "1474922336"
   )
   abstract Nameable[] vmethod5462(int var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   public void method5302() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3837.clear();
      this.field3840.clear();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1109127029"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1221554128"
   )
   public boolean method5305() {
      return this.field3838 == this.count;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lkz;I)Z",
      garbageValue = "598346158"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5427()?false:(this.field3837.containsKey(var1)?true:this.field3840.containsKey(var1));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lkz;I)Lku;",
      garbageValue = "1937396120"
   )
   public Nameable method5307(Name var1) {
      Nameable var2 = this.method5327(var1);
      return var2 != null?var2:this.method5309(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkz;I)Lku;",
      garbageValue = "2001745595"
   )
   Nameable method5327(Name var1) {
      return !var1.method5427()?null:(Nameable)this.field3837.get(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkz;B)Lku;",
      garbageValue = "109"
   )
   Nameable method5309(Name var1) {
      return !var1.method5427()?null:(Nameable)this.field3840.get(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lkz;I)Z",
      garbageValue = "447429359"
   )
   public final boolean method5344(Name var1) {
      Nameable var2 = this.method5327(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5311(var2);
         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lku;B)V",
      garbageValue = "28"
   )
   final void method5311(Nameable var1) {
      int var2 = this.method5317(var1);
      if(var2 != -1) {
         this.method5328(var2);
         this.method5318(var1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lkz;I)Lku;",
      garbageValue = "1635002869"
   )
   Nameable method5312(Name var1) {
      return this.method5313(var1, (Name)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)Lku;",
      garbageValue = "171252347"
   )
   Nameable method5313(Name var1, Name var2) {
      if(this.method5327(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5454();
         var3.method5264(var1, var2);
         this.method5349(var3);
         this.method5320(var3);
         return var3;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Lku;",
      garbageValue = "-1083084917"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   public final void method5331() {
      if(this.field3842 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3842);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lku;Lkz;Lkz;B)V",
      garbageValue = "1"
   )
   final void method5316(Nameable var1, Name var2, Name var3) {
      this.method5318(var1);
      var1.method5264(var2, var3);
      this.method5320(var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lku;I)I",
      garbageValue = "435026569"
   )
   final int method5317(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lku;I)V",
      garbageValue = "-599225602"
   )
   final void method5318(Nameable var1) {
      if(this.field3837.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3830 != null) {
            this.field3840.remove(var1.field3830);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lku;I)V",
      garbageValue = "-1714169647"
   )
   final void method5349(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lku;I)V",
      garbageValue = "-991416109"
   )
   final void method5320(Nameable var1) {
      this.field3837.put(var1.name, var1);
      if(var1.field3830 != null) {
         Nameable var2 = (Nameable)this.field3840.put(var1.field3830, var1);
         if(var2 != null && var2 != var1) {
            var2.field3830 = null;
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   final void method5328(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "689927067"
   )
   public final void method5323() {
      this.field3842 = null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "1905878488"
   )
   public final void method5324(Comparator var1) {
      if(this.field3842 == null) {
         this.field3842 = var1;
      } else if(this.field3842 instanceof class297) {
         ((class297)this.field3842).method5283(var1);
      }

   }
}
