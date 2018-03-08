import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1595816575
   )
   final int field3837;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2061584545
   )
   @Export("count")
   int count;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lkv;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("e")
   HashMap field3836;
   @ObfuscatedName("x")
   HashMap field3833;
   @ObfuscatedName("p")
   Comparator field3838;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3838 = null;
      this.field3837 = var1;
      this.nameables = this.vmethod5470(var1);
      this.field3836 = new HashMap(var1 / 8);
      this.field3833 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lkv;",
      garbageValue = "-21"
   )
   abstract Nameable vmethod5446();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[Lkv;",
      garbageValue = "-827789091"
   )
   abstract Nameable[] vmethod5470(int var1);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506073622"
   )
   public void method5297() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3836.clear();
      this.field3833.clear();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1834734088"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method5375() {
      return this.field3837 == this.count;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Z",
      garbageValue = "-1903116212"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5418()?false:(this.field3836.containsKey(var1)?true:this.field3833.containsKey(var1));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkv;",
      garbageValue = "827343278"
   )
   public Nameable method5301(Name var1) {
      Nameable var2 = this.method5302(var1);
      return var2 != null?var2:this.method5300(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkv;",
      garbageValue = "-1251202405"
   )
   Nameable method5302(Name var1) {
      return !var1.method5418()?null:(Nameable)this.field3836.get(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkb;B)Lkv;",
      garbageValue = "-31"
   )
   Nameable method5300(Name var1) {
      return !var1.method5418()?null:(Nameable)this.field3833.get(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Z",
      garbageValue = "-1384023392"
   )
   public final boolean method5304(Name var1) {
      Nameable var2 = this.method5302(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5305(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lkv;B)V",
      garbageValue = "-48"
   )
   final void method5305(Nameable var1) {
      int var2 = this.method5346(var1);
      if(var2 != -1) {
         this.method5366(var2);
         this.method5312(var1);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lkb;I)Lkv;",
      garbageValue = "-587451177"
   )
   Nameable method5336(Name var1) {
      return this.method5307(var1, (Name)null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkb;Lkb;B)Lkv;",
      garbageValue = "51"
   )
   Nameable method5307(Name var1, Name var2) {
      if(this.method5301(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5446();
         var3.method5263(var1, var2);
         this.method5313(var3);
         this.method5314(var3);
         return var3;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)Lkv;",
      garbageValue = "-1978992979"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-642707680"
   )
   public final void method5309() {
      if(this.field3838 == null) {
         Arrays.sort(this.nameables, 0, this.count);
      } else {
         Arrays.sort(this.nameables, 0, this.count, this.field3838);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkb;Lkb;I)V",
      garbageValue = "2120391441"
   )
   final void method5352(Nameable var1, Name var2, Name var3) {
      this.method5312(var1);
      var1.method5263(var2, var3);
      this.method5314(var1);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lkv;I)I",
      garbageValue = "-2106574063"
   )
   final int method5346(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lkv;B)V",
      garbageValue = "7"
   )
   final void method5312(Nameable var1) {
      if(this.field3836.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3825 != null) {
            this.field3833.remove(var1.field3825);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lkv;I)V",
      garbageValue = "-280144468"
   )
   final void method5313(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lkv;B)V",
      garbageValue = "-35"
   )
   final void method5314(Nameable var1) {
      this.field3836.put(var1.name, var1);
      if(var1.field3825 != null) {
         this.field3833.put(var1.field3825, var1);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1715049339"
   )
   final void method5366(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-155787685"
   )
   public final void method5318() {
      this.field3838 = null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-28"
   )
   public final void method5338(Comparator var1) {
      if(this.field3838 == null) {
         this.field3838 = var1;
      } else if(this.field3838 instanceof class297) {
         ((class297)this.field3838).method5272(var1);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-1135493564"
   )
   public static int method5378(CharSequence var0, int var1) {
      return IndexData.parseInt(var0, var1, true);
   }
}
