import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("UserList")
public abstract class UserList {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2119868987
   )
   @Export("capacity")
   final int capacity;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -280101247
   )
   @Export("size0")
   int size0;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Ljs;"
   )
   @Export("array")
   User[] array;
   @ObfuscatedName("g")
   @Export("usernamesMap")
   HashMap usernamesMap;
   @ObfuscatedName("l")
   @Export("previousUsernamesMap")
   HashMap previousUsernamesMap;
   @ObfuscatedName("e")
   @Export("comparator")
   Comparator comparator;

   UserList(int var1) {
      this.size0 = 0;
      this.comparator = null;
      this.capacity = var1;
      this.array = this.newTypedArray(var1);
      this.usernamesMap = new HashMap(var1 / 8);
      this.previousUsernamesMap = new HashMap(var1 / 8);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-2063112195"
   )
   @Export("newInstance")
   abstract User newInstance();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[Ljs;",
      garbageValue = "861814350"
   )
   @Export("newTypedArray")
   abstract User[] newTypedArray(int size);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1821856453"
   )
   @Export("clear")
   public void clear() {
      this.size0 = 0;
      Arrays.fill(this.array, (Object)null);
      this.usernamesMap.clear();
      this.previousUsernamesMap.clear();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1458980777"
   )
   @Export("size")
   public int size() {
      return this.size0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "482333248"
   )
   @Export("isFull")
   public boolean isFull() {
      return this.capacity == this.size0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Z",
      garbageValue = "933434965"
   )
   @Export("contains")
   public boolean contains(Username username) {
      return username.hasCleanName() && (this.usernamesMap.containsKey(username) || this.previousUsernamesMap.containsKey(username));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljs;",
      garbageValue = "-291023874"
   )
   @Export("getByUsername")
   public User getByUsername(Username username) {
      User var2 = this.getByCurrentUsername(username);
      return var2 != null ? var2 : this.getByPreviousUsername(username);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljs;",
      garbageValue = "-1364698032"
   )
   @Export("getByCurrentUsername")
   User getByCurrentUsername(Username username) {
      return !username.hasCleanName() ? null : (User)this.usernamesMap.get(username);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljs;",
      garbageValue = "-1976876334"
   )
   @Export("getByPreviousUsername")
   User getByPreviousUsername(Username previousUsername) {
      return !previousUsername.hasCleanName() ? null : (User)this.previousUsernamesMap.get(previousUsername);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lkp;S)Z",
      garbageValue = "7857"
   )
   @Export("removeByUsername")
   public final boolean removeByUsername(Username username) {
      User var2 = this.getByCurrentUsername(username);
      if (var2 == null) {
         return false;
      } else {
         this.remove(var2);
         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljs;I)V",
      garbageValue = "-1991960360"
   )
   @Export("remove")
   final void remove(User user) {
      int var2 = this.indexOf(user);
      if (var2 != -1) {
         this.arrayRemove(var2);
         this.mapRemove(user);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lkp;I)Ljs;",
      garbageValue = "-1137431921"
   )
   @Export("addLastNoPreviousUsername")
   User addLastNoPreviousUsername(Username username) {
      return this.addLast(username, (Username)null);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)Ljs;",
      garbageValue = "1445676158"
   )
   @Export("addLast")
   User addLast(Username username, Username previousUsername) {
      if (this.getByCurrentUsername(username) != null) {
         throw new IllegalStateException();
      } else {
         User var3 = this.newInstance();
         var3.set(username, previousUsername);
         this.arrayAddLast(var3);
         this.mapPut(var3);
         return var3;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)Ljs;",
      garbageValue = "-1676228472"
   )
   @Export("get")
   public final User get(int index) {
      if (index >= 0 && index < this.size0) {
         return this.array[index];
      } else {
         throw new ArrayIndexOutOfBoundsException(index);
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-337545643"
   )
   @Export("sort")
   public final void sort() {
      if (this.comparator == null) {
         Arrays.sort(this.array, 0, this.size0);
      } else {
         Arrays.sort(this.array, 0, this.size0, this.comparator);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljs;Lkp;Lkp;B)V",
      garbageValue = "35"
   )
   @Export("changeName")
   final void changeName(User user, Username username, Username previousUsername) {
      this.mapRemove(user);
      user.set(username, previousUsername);
      this.mapPut(user);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ljs;I)I",
      garbageValue = "-1908653684"
   )
   @Export("indexOf")
   final int indexOf(User user) {
      for (int var2 = 0; var2 < this.size0; ++var2) {
         if (this.array[var2] == user) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljs;S)V",
      garbageValue = "-20791"
   )
   @Export("mapRemove")
   final void mapRemove(User user) {
      if (user.previousUsername != null) {
         this.previousUsernamesMap.remove(user.previousUsername);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljs;I)V",
      garbageValue = "1398315954"
   )
   @Export("arrayAddLast")
   final void arrayAddLast(User user) {
      this.array[++this.size0 - 1] = user;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljs;B)V",
      garbageValue = "103"
   )
   @Export("mapPut")
   final void mapPut(User user) {
      this.usernamesMap.put(user.username, user);
      if (user.previousUsername != null) {
         User var2 = (User)this.previousUsernamesMap.put(user.previousUsername, user);
         if (var2 != null && var2 != user) {
            var2.previousUsername = null;
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-616972929"
   )
   @Export("arrayRemove")
   final void arrayRemove(int index) {
      --this.size0;
      if (index < this.size0) {
         System.arraycopy(this.array, index + 1, this.array, index, this.size0 - index);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1875022477"
   )
   @Export("removeComparator")
   public final void removeComparator() {
      this.comparator = null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-128"
   )
   @Export("addComparator")
   public final void addComparator(Comparator var1) {
      if (this.comparator == null) {
         this.comparator = var1;
      } else if (this.comparator instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.comparator).addComparator(var1);
      }

   }
}
