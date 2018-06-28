import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1304434647
   )
   final int field3642;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1391335809
   )
   @Export("count")
   int count;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Ljn;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("h")
   HashMap field3641;
   @ObfuscatedName("x")
   HashMap field3640;
   @ObfuscatedName("j")
   Comparator field3643;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3643 = null;
      this.field3642 = var1;
      this.nameables = this.vmethod5492(var1);
      this.field3641 = new HashMap(var1 / 8);
      this.field3640 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljn;",
      garbageValue = "-39"
   )
   abstract Nameable vmethod5491();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljn;",
      garbageValue = "-1283030275"
   )
   abstract Nameable[] vmethod5492(int var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public void method5340() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3641.clear();
      this.field3640.clear();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-163166883"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-512164530"
   )
   public boolean method5342() {
      return this.field3642 == this.count;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkm;I)Z",
      garbageValue = "1132934568"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.isCleanNameValid()?false:(this.field3641.containsKey(var1)?true:this.field3640.containsKey(var1));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lkm;I)Ljn;",
      garbageValue = "-541687086"
   )
   public Nameable method5344(Name var1) {
      Nameable var2 = this.method5374(var1);
      return var2 != null?var2:this.method5346(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkm;I)Ljn;",
      garbageValue = "1140436781"
   )
   Nameable method5374(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3641.get(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lkm;B)Ljn;",
      garbageValue = "127"
   )
   Nameable method5346(Name var1) {
      return !var1.isCleanNameValid()?null:(Nameable)this.field3640.get(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lkm;S)Z",
      garbageValue = "-129"
   )
   public final boolean method5397(Name var1) {
      Nameable var2 = this.method5374(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5362(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljn;I)V",
      garbageValue = "-581957899"
   )
   final void method5362(Nameable var1) {
      int var2 = this.method5347(var1);
      if(var2 != -1) {
         this.method5415(var2);
         this.method5355(var1);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lkm;I)Ljn;",
      garbageValue = "783801932"
   )
   Nameable method5349(Name var1) {
      return this.method5373(var1, (Name)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;B)Ljn;",
      garbageValue = "-36"
   )
   Nameable method5373(Name var1, Name var2) {
      if(this.method5374(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5491();
         var3.setName(var1, var2);
         this.method5356(var3);
         this.method5379(var3);
         return var3;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)Ljn;",
      garbageValue = "-873213050"
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
      garbageValue = "109"
   )
   public final void method5383() {
      if(this.field3643 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3643);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljn;Lkm;Lkm;B)V",
      garbageValue = "-124"
   )
   final void method5339(Nameable var1, Name var2, Name var3) {
      this.method5355(var1);
      var1.setName(var2, var3);
      this.method5379(var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljn;I)I",
      garbageValue = "-108845866"
   )
   final int method5347(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljn;B)V",
      garbageValue = "125"
   )
   final void method5355(Nameable var1) {
      if(this.field3641.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.prevName != null) {
            this.field3640.remove(var1.prevName);
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljn;I)V",
      garbageValue = "1626391782"
   )
   final void method5356(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljn;B)V",
      garbageValue = "-14"
   )
   final void method5379(Nameable var1) {
      this.field3641.put(var1.name, var1);
      if(var1.prevName != null) {
         Nameable var2 = (Nameable)this.field3640.put(var1.prevName, var1);
         if(var2 != null && var2 != var1) {
            var2.prevName = null;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   final void method5415(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "935713082"
   )
   public final void method5361() {
      this.field3643 = null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-1"
   )
   public final void method5381(Comparator var1) {
      if(this.field3643 == null) {
         this.field3643 = var1;
      } else if(this.field3643 instanceof class283) {
         ((class283)this.field3643).method5319(var1);
      }

   }
}
