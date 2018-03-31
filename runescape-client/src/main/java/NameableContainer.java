import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1280829289
   )
   final int field3833;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -263697855
   )
   @Export("count")
   int count;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lku;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("z")
   HashMap field3830;
   @ObfuscatedName("p")
   HashMap field3831;
   @ObfuscatedName("w")
   Comparator field3835;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3835 = null;
      this.field3833 = var1;
      this.nameables = this.vmethod5463(var1);
      this.field3830 = new HashMap(var1 / 8);
      this.field3831 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "437342171"
   )
   abstract Nameable vmethod5462();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "-1281183690"
   )
   abstract Nameable[] vmethod5463(int var1);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1949425142"
   )
   public void method5351() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3830.clear();
      this.field3831.clear();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1726610153"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-101234171"
   )
   public boolean method5315() {
      return this.count == this.field3833;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lko;B)Z",
      garbageValue = "78"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5450()?false:(this.field3830.containsKey(var1)?true:this.field3831.containsKey(var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lku;",
      garbageValue = "-1671660530"
   )
   public Nameable method5317(Name var1) {
      Nameable var2 = this.method5319(var1);
      return var2 != null?var2:this.method5359(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lku;",
      garbageValue = "1565981457"
   )
   Nameable method5319(Name var1) {
      return !var1.method5450()?null:(Nameable)this.field3830.get(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lku;",
      garbageValue = "1058550691"
   )
   Nameable method5359(Name var1) {
      return !var1.method5450()?null:(Nameable)this.field3831.get(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lko;I)Z",
      garbageValue = "-1439538729"
   )
   public final boolean method5345(Name var1) {
      Nameable var2 = this.method5319(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5321(var2);
         return true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lku;I)V",
      garbageValue = "-2023066402"
   )
   final void method5321(Nameable var1) {
      int var2 = this.method5327(var1);
      if(var2 != -1) {
         this.method5346(var2);
         this.method5328(var1);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lko;I)Lku;",
      garbageValue = "1156446856"
   )
   Nameable method5322(Name var1) {
      return this.method5323(var1, (Name)null);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lko;Lko;B)Lku;",
      garbageValue = "9"
   )
   Nameable method5323(Name var1, Name var2) {
      if(this.method5319(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5462();
         var3.method5263(var1, var2);
         this.method5372(var3);
         this.method5329(var3);
         return var3;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)Lku;",
      garbageValue = "-1380247516"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-110"
   )
   public final void method5333() {
      if(this.field3835 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3835);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lku;Lko;Lko;I)V",
      garbageValue = "-1981507025"
   )
   final void method5326(Nameable var1, Name var2, Name var3) {
      this.method5328(var1);
      var1.method5263(var2, var3);
      this.method5329(var1);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lku;I)I",
      garbageValue = "-666196517"
   )
   final int method5327(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lku;S)V",
      garbageValue = "-12156"
   )
   final void method5328(Nameable var1) {
      if(this.field3830.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3822 != null) {
            this.field3831.remove(var1.field3822);
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lku;B)V",
      garbageValue = "60"
   )
   final void method5372(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lku;B)V",
      garbageValue = "118"
   )
   final void method5329(Nameable var1) {
      this.field3830.put(var1.name, var1);
      if(var1.field3822 != null) {
         Nameable var2 = (Nameable)this.field3831.put(var1.field3822, var1);
         if(var2 != null && var2 != var1) {
            var2.field3822 = null;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "41"
   )
   final void method5346(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1408308019"
   )
   public final void method5334() {
      this.field3835 = null;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "1218205876"
   )
   public final void method5377(Comparator var1) {
      if(this.field3835 == null) {
         this.field3835 = var1;
      } else if(this.field3835 instanceof class297) {
         ((class297)this.field3835).method5287(var1);
      }

   }
}
