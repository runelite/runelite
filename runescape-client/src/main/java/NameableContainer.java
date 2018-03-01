import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -314921597
   )
   final int field3834;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 451707839
   )
   @Export("count")
   int count;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("k")
   HashMap field3832;
   @ObfuscatedName("s")
   HashMap field3835;
   @ObfuscatedName("p")
   Comparator field3836;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3836 = null;
      this.field3834 = var1;
      this.nameables = this.vmethod5575(var1);
      this.field3832 = new HashMap(var1 / 8);
      this.field3835 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-2116343302"
   )
   abstract Nameable vmethod5562();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)[Lkm;",
      garbageValue = "164976155"
   )
   abstract Nameable[] vmethod5575(int var1);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method5409() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3832.clear();
      this.field3835.clear();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-83"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "11"
   )
   public boolean method5411() {
      return this.field3834 == this.count;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lko;S)Z",
      garbageValue = "19375"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5533()?false:(this.field3832.containsKey(var1)?true:this.field3835.containsKey(var1));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lkm;",
      garbageValue = "2090090919"
   )
   public Nameable method5452(Name var1) {
      Nameable var2 = this.method5414(var1);
      return var2 != null?var2:this.method5490(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lkm;",
      garbageValue = "572713180"
   )
   Nameable method5414(Name var1) {
      return !var1.method5533()?null:(Nameable)this.field3832.get(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lko;B)Lkm;",
      garbageValue = "0"
   )
   Nameable method5490(Name var1) {
      return !var1.method5533()?null:(Nameable)this.field3835.get(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lko;I)Z",
      garbageValue = "-1473776381"
   )
   public final boolean method5416(Name var1) {
      Nameable var2 = this.method5414(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5417(var2);
         return true;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lkm;I)V",
      garbageValue = "-1842430852"
   )
   final void method5417(Nameable var1) {
      int var2 = this.method5484(var1);
      if(var2 != -1) {
         this.method5426(var2);
         this.method5424(var1);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lkm;",
      garbageValue = "421563342"
   )
   Nameable method5451(Name var1) {
      return this.method5467(var1, (Name)null);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lko;Lko;I)Lkm;",
      garbageValue = "1912509477"
   )
   Nameable method5467(Name var1, Name var2) {
      if(this.method5452(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5562();
         var3.method5367(var1, var2);
         this.method5447(var3);
         this.method5450(var3);
         return var3;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)Lkm;",
      garbageValue = "-41"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "50942510"
   )
   public final void method5421() {
      if(this.field3836 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3836);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lkm;Lko;Lko;B)V",
      garbageValue = "0"
   )
   final void method5437(Nameable var1, Name var2, Name var3) {
      this.method5424(var1);
      var1.method5367(var2, var3);
      this.method5450(var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "-1712731398"
   )
   final int method5484(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lkm;I)V",
      garbageValue = "-218274751"
   )
   final void method5424(Nameable var1) {
      if(this.field3832.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3824 != null) {
            this.field3835.remove(var1.field3824);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lkm;I)V",
      garbageValue = "-1307192509"
   )
   final void method5447(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lkm;B)V",
      garbageValue = "-127"
   )
   final void method5450(Nameable var1) {
      this.field3832.put(var1.name, var1);
      if(var1.field3824 != null) {
         this.field3835.put(var1.field3824, var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "944965721"
   )
   final void method5426(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-626920096"
   )
   public final void method5440() {
      this.field3836 = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "69"
   )
   public final void method5430(Comparator var1) {
      if(this.field3836 == null) {
         this.field3836 = var1;
      } else if(this.field3836 instanceof class297) {
         ((class297)this.field3836).method5388(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "16"
   )
   public static int method5436(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
