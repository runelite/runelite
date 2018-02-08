import java.awt.Image;
import java.util.Arrays;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("ak")
   static Image field3712;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -904170727
   )
   final int field3707;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1546687899
   )
   @Export("count")
   int count;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ljq;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("t")
   HashMap field3710;
   @ObfuscatedName("d")
   HashMap field3709;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3707 = var1;
      this.nameables = this.vmethod5331(var1);
      this.field3710 = new HashMap(var1 / 8);
      this.field3709 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljq;",
      garbageValue = "-1161467535"
   )
   abstract Nameable vmethod5308();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[Ljq;",
      garbageValue = "-1191416525"
   )
   abstract Nameable[] vmethod5331(int var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-705752554"
   )
   public void method5245() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3710.clear();
      this.field3709.clear();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1704591023"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1803118338"
   )
   public boolean method5170() {
      return this.field3707 == this.count;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lja;B)Z",
      garbageValue = "81"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5276()?false:(this.field3710.containsKey(var1)?true:this.field3709.containsKey(var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lja;B)Ljq;",
      garbageValue = "85"
   )
   Nameable method5171(Name var1) {
      Nameable var2 = this.method5173(var1);
      return var2 != null?var2:this.method5204(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lja;I)Ljq;",
      garbageValue = "-1187686851"
   )
   Nameable method5173(Name var1) {
      return !var1.method5276()?null:(Nameable)this.field3710.get(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lja;I)Ljq;",
      garbageValue = "1347016027"
   )
   Nameable method5204(Name var1) {
      return !var1.method5276()?null:(Nameable)this.field3709.get(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lja;I)Z",
      garbageValue = "-1429637473"
   )
   public final boolean method5175(Name var1) {
      Nameable var2 = this.method5173(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5176(var2);
         return true;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljq;B)V",
      garbageValue = "12"
   )
   final void method5176(Nameable var1) {
      int var2 = this.method5181(var1);
      if(var2 != -1) {
         this.method5213(var2);
         this.method5183(var1);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lja;I)Ljq;",
      garbageValue = "-961929102"
   )
   Nameable method5177(Name var1) {
      return this.method5178(var1, (Name)null);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lja;Lja;I)Ljq;",
      garbageValue = "-918362084"
   )
   Nameable method5178(Name var1, Name var2) {
      if(this.method5171(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5308();
         var3.method5139(var1, var2);
         this.method5184(var3);
         this.method5174(var3);
         return var3;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)Ljq;",
      garbageValue = "2027421299"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-110706006"
   )
   public final void method5180() {
      Arrays.sort(this.nameables, 0, this.count);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljq;Lja;Lja;I)V",
      garbageValue = "-817434855"
   )
   final void method5222(Nameable var1, Name var2, Name var3) {
      this.method5183(var1);
      var1.method5139(var2, var3);
      this.method5174(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Ljq;I)I",
      garbageValue = "725467222"
   )
   final int method5181(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljq;I)V",
      garbageValue = "-1809308029"
   )
   final void method5183(Nameable var1) {
      if(this.field3710.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3700 != null) {
            this.field3709.remove(var1.field3700);
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljq;I)V",
      garbageValue = "641542104"
   )
   final void method5184(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljq;I)V",
      garbageValue = "-1327934234"
   )
   final void method5174(Nameable var1) {
      this.field3710.put(var1.name, var1);
      if(var1.field3700 != null) {
         this.field3709.put(var1.field3700, var1);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "922683996"
   )
   final void method5213(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "824080630"
   )
   static final void method5186() {
      BoundingBox3D.method49("You can\'t add yourself to your own friend list");
   }
}
