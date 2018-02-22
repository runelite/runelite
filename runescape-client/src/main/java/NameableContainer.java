import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -199890583
   )
   final int field3709;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -462879747
   )
   @Export("count")
   int count;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("l")
   HashMap field3711;
   @ObfuscatedName("y")
   HashMap field3712;
   @ObfuscatedName("g")
   Comparator field3714;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3714 = null;
      this.field3709 = var1;
      this.nameables = this.vmethod5396(var1);
      this.field3711 = new HashMap(var1 / 8);
      this.field3712 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljw;",
      garbageValue = "-258832734"
   )
   abstract Nameable vmethod5393();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)[Ljw;",
      garbageValue = "-1"
   )
   abstract Nameable[] vmethod5396(int var1);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1509678360"
   )
   public void method5230() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3711.clear();
      this.field3712.clear();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2104665892"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "25"
   )
   public boolean method5232() {
      return this.field3709 == this.count;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Z",
      garbageValue = "-1823048070"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5359()?false:(this.field3711.containsKey(var1)?true:this.field3712.containsKey(var1));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljw;",
      garbageValue = "-986255906"
   )
   Nameable method5307(Name var1) {
      Nameable var2 = this.method5235(var1);
      return var2 != null?var2:this.method5286(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljw;",
      garbageValue = "554419716"
   )
   Nameable method5235(Name var1) {
      return !var1.method5359()?null:(Nameable)this.field3711.get(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljw;",
      garbageValue = "-221263464"
   )
   Nameable method5286(Name var1) {
      return !var1.method5359()?null:(Nameable)this.field3712.get(var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Z",
      garbageValue = "-1910666126"
   )
   public final boolean method5264(Name var1) {
      Nameable var2 = this.method5235(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5238(var2);
         return true;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljw;B)V",
      garbageValue = "120"
   )
   final void method5238(Nameable var1) {
      int var2 = this.method5244(var1);
      if(var2 != -1) {
         this.method5283(var2);
         this.method5245(var1);
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lkp;B)Ljw;",
      garbageValue = "-1"
   )
   Nameable method5269(Name var1) {
      return this.method5240(var1, (Name)null);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)Ljw;",
      garbageValue = "1181037167"
   )
   Nameable method5240(Name var1, Name var2) {
      if(this.method5307(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5393();
         var3.method5199(var1, var2);
         this.method5311(var3);
         this.method5247(var3);
         return var3;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)Ljw;",
      garbageValue = "-119"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1062513560"
   )
   public final void method5242() {
      if(this.field3714 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3714);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljw;Lkp;Lkp;I)V",
      garbageValue = "644137873"
   )
   final void method5243(Nameable var1, Name var2, Name var3) {
      this.method5245(var1);
      var1.method5199(var2, var3);
      this.method5247(var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljw;B)I",
      garbageValue = "-102"
   )
   final int method5244(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljw;B)V",
      garbageValue = "67"
   )
   final void method5245(Nameable var1) {
      if(this.field3711.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3700 != null) {
            this.field3712.remove(var1.field3700);
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljw;B)V",
      garbageValue = "-38"
   )
   final void method5311(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ljw;I)V",
      garbageValue = "-666354473"
   )
   final void method5247(Nameable var1) {
      this.field3711.put(var1.name, var1);
      if(var1.field3700 != null) {
         this.field3712.put(var1.field3700, var1);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-64"
   )
   final void method5283(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1207541451"
   )
   public final void method5305() {
      this.field3714 = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "1586613347"
   )
   public final void method5252(Comparator var1) {
      if(this.field3714 == null) {
         this.field3714 = var1;
      } else if(this.field3714 instanceof class283) {
         ((class283)this.field3714).method5215(var1);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Llv;",
      garbageValue = "1895823189"
   )
   static IndexedSprite method5288() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class323.field3913;
      var0.originalHeight = class323.field3915;
      var0.offsetX = TotalQuantityComparator.field281[0];
      var0.offsetY = FileSystem.offsetsY[0];
      var0.originalWidth = BaseVarType.field28[0];
      var0.height = GroundObject.field1751[0];
      var0.palette = class323.field3912;
      var0.pixels = class323.spritePixels[0];
      class152.method3133();
      return var0;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2009852221"
   )
   static void method5318() {
      if(Client.spellSelected) {
         Widget var0 = class201.getWidgetChild(MouseRecorder.field761, Client.field959);
         if(var0 != null && var0.field2869 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2869;
            class194.method3791(var1);
         }

         Client.spellSelected = false;
         ScriptEvent.method1132(var0);
      }
   }
}
